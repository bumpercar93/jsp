package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceImplTest {
	
	private ILprodService lprodService;
	
	@Before
	public void setup() {
		lprodService = new LprodServiceImpl();
	}

	@Test
	public void lprodPagingList() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVO);
		List<LprodVO> lprodList = (List<LprodVO>) resultMap.get("lprodList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals(2, paginationSize);
	}

}
