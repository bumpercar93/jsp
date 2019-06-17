package kr.or.ddit.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDaoImpl;
import kr.or.ddit.db.dao.DbDaoImplTest;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.db.service.DbServiceImpl;
import kr.or.ddit.db.service.IDbService;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbServiceImplTest {

	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoImplTest.class);
	
	private IDbService dbService;
	
	@Before
	public void setup() {
		dbService = new DbServiceImpl();
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
		List<DbVO> dbList = dbService.getAllUriMapping();

		/***Then***/
		assertNotNull(dbList);
		assertEquals(2, dbList.size());
		logger.debug("dbList : {}", dbList);

	}

}
