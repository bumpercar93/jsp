package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;

public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	private IUserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	/**
	* 
	* Method : userList
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@Override
	public List<UserVO> userList() {
		List<UserVO> userList = userDao.userList();
		return userList;
	}
	
	/**
	* 
	* Method : getUser
	* 작성자 : PC06
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		UserVO userVO = userDao.getUser(userId);
		return userVO;
	}
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC06
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVO pageVO) {
		// 1. List<UserVO>, userCnt를 필드로 하는 VO 생성
		// 2. List<Object>를 이용
		// 3. Map<String Object>를 이용
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userDao.userPagingList(pageVO));
		
		// UsersCnt --> paginationSize 변경
		int usersCnt = userDao.usersCnt();
		// pageSize --> pageVO.getPageSize();
		int paginationSize = (int) Math.ceil((double)usersCnt/pageVO.getPageSize());
		
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC06
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVO userVO) {
		return userDao.insertUser(userVO);
	}
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC06
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	/**
	 * 
	* Method : updateUser
	* 작성자 : PC06
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 사용자 수정
	 */
	@Override
	public int updateUser(UserVO userVO) {
		return userDao.updateUser(userVO);
	}
	
	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치, 재적용 하지 말 것
	 */
	@Override
	public int encryptPassAllUser() {
		// 사용하지 마세요! 이미 암호화 적용됨
		if(1 == 1) return 0;
		
		// 0. SQL 실행에 필요한 SqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		// 1. 모든 사용자 정보 조회(단, 기존 암호화 적용 사용자 제외)
		List<UserVO> userList = userDao.userListForPassEncrypt(sqlSession);
		
		// 2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트
		int updateCntSum = 0;
		for(UserVO userVO : userList) {
			String encryptPass = KISA_SHA256.encrypt(userVO.getPass());
			userVO.setPass(encryptPass);
			
			int updateCnt = userDao.updateUserEncryptPass(sqlSession, userVO);
			updateCntSum += updateCnt;
			
			// 업데이트 실패
			if(updateCnt != 1) {
				sqlSession.rollback();
				break;
			}
		}
		
		// 3. SqlSession 객체를 Commit 후 Close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum;
	}
	
	public static void main(String[] args) {
		IUserService userService = new UserServiceImpl();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {}", updateCnt);
	}
	

}
