package com.inhatc.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inhatc.domain.BookVO;

@Repository("BookDAO")
public interface BookDAO {

	public void create(BookVO vo)throws Exception;
	
	public List<BookVO> read(BookVO vo)throws Exception;
	
	public void update(BookVO vo)throws Exception;
	
	public void delete(int no)throws Exception;
	
	public List<BookVO> listAll(BookVO bookVO)throws Exception;

	public List<BookVO> typelist(BookVO bookVO)throws Exception;

	public List<BookVO> classifylist(BookVO bookVO)throws Exception;

	public List<BookVO> stypelist(BookVO bookVO)throws Exception;
}
