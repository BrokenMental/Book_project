package com.inhatc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.inhatc.mapper.BookMapper";

	@Override
	public void create(BookVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".create", vo);
	}

	@Override
	public BookVO read(Integer no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", no);
	}

	@Override
	public void update(BookVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".create", vo);
		
	}

	@Override
	public void delete(Integer no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".create", no);
		
	}

	@Override
	public List<BookVO> listAll(BookVO bookVO) throws Exception{
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}
	

}
