package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao {

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
	public List<LprodVO> lprodPagingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodPagingList", pageVO);
		sqlSession.close();
		return lprodList;
	}

	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC06
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
	 */
	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int cnt = sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		return cnt;
	}

}
