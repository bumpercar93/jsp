package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbDaoImplTest {

	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoImplTest.class);
	
	private IDbDao dbDao;
	
	@Before
	public void setup() {
		dbDao = new DbDaoImpl();
	}
	
	
	/**
	 * 
	* Method : getAllUriMappingTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : urimapping 테이블 모든 정보 가져오기 테스트
	 */
	@Test
	public void getAllUriMappingTest() {
		/***Given***/
		
		/***When***/
		List<DbVO> dbList = dbDao.getAllUriMapping();

		/***Then***/
		assertNotNull(dbList);
		assertEquals(2, dbList.size());
		logger.debug("dbList : {}", dbList);

	}

}
