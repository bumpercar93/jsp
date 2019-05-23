package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVO;

public class UserServiceImpl implements IUserService {

	/**
	* 
	* Method : userList
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVO> userList() {
		// DB에서 데이터를 조회했다고 가정
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO("브라운", "brown", "곰"));
		userList.add(new UserVO("코니", "cony", "토끼"));
		userList.add(new UserVO("셀리", "sally", "병아리"));
		userList.add(new UserVO("제임스", "james", "사람"));
		userList.add(new UserVO("문", "moon", "달"));
		userList.add(new UserVO("김범휘", "kbh", "범휘"));
		
		return userList;
	}

}
