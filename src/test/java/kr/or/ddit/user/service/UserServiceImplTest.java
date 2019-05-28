package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {
	
	private IUserService userService;
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImplTest.class);
	
	@Before
	public void setup() {
		userService = new UserServiceImpl();
	}
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		
		/***Given***/

		/***When***/
		List<UserVO> userList = userService.userList();
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(105, userList.size());
	}
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUser() {
		
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVO = userService.getUser(userId);
		
		/***Then***/
		assertNotNull(userVO);
		assertEquals(userId, userVO.getUserId());
	}

	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingList() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		/***Then***/
		// pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		// usersCnt assert
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest() {
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {} ", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
}
