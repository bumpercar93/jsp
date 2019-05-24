package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {
	
	private IUserService userService;
	
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

}
