package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserService {
	
	/**
	* 
	* Method : userList
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	public List<UserVO> userList();
	
}
