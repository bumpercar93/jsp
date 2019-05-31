package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImplTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImplTest.class);
	
	private IUserDao userDao;
	
	// JUnit 실행순서
	// @BeforeClass가 적용된 메서드가 1회 실행
	
	// 다음 구간은 @Test가 적용된 모든 메서드에 대해 반복 적용
	// @Before가 적용된 메서드 실행
	// @Test가 적용된 메서드가 실행
	// @After가 적용된 메서드가 실행
	
	// @AfterClass가 적용된 메서드가 1회 실행
	
	@BeforeClass
	public static void beforeClass() {
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup() {
		userDao = new UserDaoImpl();
		logger.debug("setup");
	}
	
	@After
	public void teardown() {
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.debug("afterClass");
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
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVO.getName());
		logger.debug("userVO : {}", userVO);
	}
	
	
	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇 번째 페이지 조회인지?, 페이지 당 몇 건씩 데이터를 보여줄건지? : 쿼리 실행 파라미터 관련
	// 정렬순서를 무엇으로 할지? : 로직 관련 ---> 파라미터화 시킬 수 있다 ---> 사용자 아이디 순으로 정렬
	
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
		List<UserVO> userList = userDao.userPagingList(pageVO);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	 */
	@Test
	public void usersCntTest(){
		/***Given***/
		
		/***When***/
		int usersCnt = userDao.usersCnt();
		
		/***Then***/
		assertEquals(105, usersCnt);
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() {
		/***Given***/
		// 사용자 정보를 담고 있는 VO객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = null;
		try {
			userVO = new UserVO("testName", "testId", "testAlias", "test1234", 
					"testAddr1", "testAddr2", "12345", sdf.parse("1993-10-17"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/***When***/
		// userDao.insertUser();
		int insertCnt = userDao.insertUser(userVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		//data 삭제
		userDao.deleteUser(userVO.getUserId());
	}
	
	/**
	 * 
	* Method : updateUserTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 사용자 수정 테스트
	 */
	@Test
	public void updateUserTest() {
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = null;
		try {
			userVO = new UserVO("test", "testId", "test", "test1234", "test", "test", "12345", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/***When***/
		int updateCnt = userDao.updateUser(userVO);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}

}
