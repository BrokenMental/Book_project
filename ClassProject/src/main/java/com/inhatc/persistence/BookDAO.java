package com.inhatc.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inhatc.domain.BookVO;

@Repository("BookDAO")
public interface BookDAO {

	public void create(BookVO vo)throws Exception;
	
	public BookVO read(Integer no)throws Exception;
	
	public void update(BookVO vo)throws Exception;
	
	public void delete(Integer no)throws Exception;
	
	public List<BookVO> listAll(BookVO bookVO)throws Exception;
}
