package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbDaoImpl;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVO;

public class DbServiceImpl implements IDbService {
	
	private IDbDao dbDao;
	
	public DbServiceImpl() {
		dbDao = new DbDaoImpl();
	}
	
	/**
	 * 
	* Method : getAllUriMapping
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : urimapping 테이블 모든 정보 가져오기
	 */
	@Override
	public List<DbVO> getAllUriMapping() {
		return dbDao.getAllUriMapping();
	}

}
