package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(UserPagingController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int page = 1;
//		int pageSize = 10;
//		if(request.getParameter("page") != null){
//			page = Integer.parseInt(request.getParameter("page"));
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
//		}
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap = userService.userPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("userPagingList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVO", pageVO);
		
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	}

}
