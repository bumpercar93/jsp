package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	/**
	 * 
	* Method : getCookieTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : getCookie 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=true; test=testValue";
		CookieUtil.setCookieString(cookieString);

		/***When***/
		String cookieValue = CookieUtil.getCookie("userId");
		String cookieValue1 = CookieUtil.getCookie("rememberme");
		String cookieValue2 = CookieUtil.getCookie("test");
		String cookieValue3 = CookieUtil.getCookie("test132123");
		String cookieValue4 = CookieUtil.getCookie("userI");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("true", cookieValue1);
		assertEquals("testValue", cookieValue2);
		assertEquals("", cookieValue3);
		assertEquals("", cookieValue4);
	}

}
