package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements IUserDao{

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);
	
	public static void main(String[] args) {
		
		/***Given***/
		IUserDao userDao = new UserDaoImpl();

		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		logger.debug("userList : {}", userList);
		
		//---------------------------------------------------------
		
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVO uVO = userDao.getUser(userId);
		
		/***Then***/
		logger.debug("userVO : {}", uVO);
		
	}

	/**
	* 
	* Method : userList
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		return userList;
	}
	
	/**
	* 
	* Method : getUser
	* 작성자 : PC06
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO uVO = sqlSession.selectOne("user.getUser", userId);
		return uVO;
	}

}
