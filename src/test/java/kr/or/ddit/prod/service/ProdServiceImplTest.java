package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;

public class ProdServiceImplTest {
	
	private IProdService prodService;
	
	@Before
	public void setup() {
		prodService = new ProdServiceImpl();
	}

	/**
	 * 
	* Method : getProdforLguTest
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : prod_lgu에 해당하는 prodVO리스트를 가져온다.
	 */
	@Test
	public void getProdforLguTest() {
		/***Given***/
		String prod_lgu = "P101";

		/***When***/
		List<ProdVO> prodList = prodService.getProdforLgu(prod_lgu);

		/***Then***/
		assertNotNull(prodList);
		assertEquals(6, prodList.size());
		
	}
}
