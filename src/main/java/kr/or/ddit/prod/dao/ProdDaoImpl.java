package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVO;

public class ProdDaoImpl implements IProdDao {

	/**
	 * 
	* Method : getProdforLgu
	* 작성자 : PC06
	* 변경이력 :
	* @param prod_lgu
	* @return
	* Method 설명 : prod_lgu에 해당하는 prodVO리스트를 가져온다.
	 */
	@Override
	public List<ProdVO> getProdforLgu(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVO> prodList = sqlSession.selectList("prod.getProdforLgu", prod_lgu);
		sqlSession.close();
		return prodList;
	}

}
