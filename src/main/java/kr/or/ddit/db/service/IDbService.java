package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

public interface IDbService {

	/**
	 * 
	* Method : getAllUriMapping
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : urimapping 테이블 모든 정보 가져오기
	 */
	List<DbVO> getAllUriMapping();

}
