package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDaoImpl implements IDbDao {

	/**
	 * 
	* Method : getAllUriMapping
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : uriMapping 테이블 모든 정보 가져오기
	 */
	@Override
	public List<DbVO> getAllUriMapping() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVO> dbList = sqlSession.selectList("db.getAllUriMapping");
		sqlSession.close();
		return dbList;
	}

}
