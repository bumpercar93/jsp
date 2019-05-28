package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.UserDaoImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoImplTest {
	
	private ILprodDao lprodDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDaoImplTest.class);
	
	@Before
	public void setup() {
		lprodDao = new LprodDaoImpl();
	}
	
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);

		/***When***/
		List<LprodVO> lprodList = lprodDao.lprodPagingList(pageVO);

		/***Then***/
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
	}
	
	@Test
	public void lprodCnt() {
		/***Given***/
		

		/***When***/
		int cnt = lprodDao.lprodCnt();
		
		/***Then***/
		assertEquals(9, cnt);
		
	}

}
