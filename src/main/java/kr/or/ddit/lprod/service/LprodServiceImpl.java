package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public class LprodServiceImpl implements ILprodService {

	private ILprodDao lprodDao;

	public LprodServiceImpl() {
		lprodDao = new LprodDaoImpl();
	}
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC06
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 : lprod 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> lprodPagingList(PageVO pageVO) {
		List<LprodVO> lprodList = lprodDao.lprodPagingList(pageVO);
		int cnt = lprodDao.lprodCnt();
		int paginationSize = (int) Math.ceil((double)cnt/pageVO.getPageSize());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("paginationSize", paginationSize);
		resultMap.put("lprodList", lprodList);
		
		return resultMap;
	}
	
}
