package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class); 
	
    private IUserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserServiceImpl();
    }
    
	// 사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm doPost");
		
		// 사용자가 보낸 파라미터를 사용해서 UserVO 인스턴스를 만들어서 
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		String pass = request.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVO = null;
		try {
			userVO = new UserVO(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO dbUser = userService.getUser(userId);
		
		// 등록된 사용자가 아닌 경우 --> 정상입력이 가능한 상황
		if(dbUser == null) {
			
			// profile 파일 업로드 처리
			Part profile = request.getPart("profile");
			if(profile.getSize() > 0) { // 사용자가 파일을 업로드 할 경우
				// 실제파일명
				String contentDisposition = profile.getHeader("content-disposition");
				String filename = PartUtil.getFileName(contentDisposition);
				String ext = PartUtil.getExt(filename);
				
				String uploadPath = PartUtil.getUploadPath();
				
				File uploadFolder = new File(uploadPath);
				if(uploadFolder.exists()) {
					// 파일 디스크에 쓰기
					String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
					
					userVO.setPath(filePath);
					userVO.setFilename(filename);
					
					profile.write(filePath);
					profile.delete(); // 임시파일 지우기
				}
				
			}
			
			int insertCnt = userService.insertUser(userVO);
			
			// 정상 등록된 경우
			if(insertCnt == 1) {
				// 사용자페이징 리스트 1페이지로 이동
				response.sendRedirect(request.getContextPath() + "/userPagingList");
			}
			// 정상적으로 입력되지 않은 경우
			// 사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		}else { // 아이디가 중복된 경우
			// 사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
			// 이미 존재하는 ID 입니다 (alert or text로 표시)
			request.setAttribute("msg", "이미 존재하는 사용자입니다.");
			doGet(request, response); // request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		}
		
	}

}
