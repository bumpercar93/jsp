package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDispositon = "form-data; name=\"profile\"; filename=\"chopa.jpg\"";

		/***When***/
		String fileName = PartUtil.getFileName(contentDispositon);

		/***Then***/
		assertEquals("chopa.jpg", fileName);
	}
	
	@Test
	public void uuidTest() {
		/***Given***/

		/***When***/
		logger.debug("UUID.randomUUID().toString() : {}", UUID.randomUUID().toString());
		
		/***Then***/

	}
	
	/**
	 * 
	* Method : getExtTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 파일 확장자 확인 테스트
	 */
	@Test
	public void getExtTest() {
		/***Given***/
		String fileName = "chopa.jpg";
		String fileName2 = "chopa.picture.jpg";
		String fileName3 = "chopa";

		/***When***/
		String ext = PartUtil.getExt(fileName);
		String ext2 = PartUtil.getExt(fileName2);
		String ext3 = PartUtil.getExt(fileName3);
		
		/***Then***/
		assertEquals("jpg", ext);
		assertEquals("jpg", ext2);
		assertEquals("", ext3);

	}
	
	@Test
	public void substringTest() {
		/***Given***/
		String yyyyMM = "201906";

		/***When***/
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4);
		
		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);
	}

}
