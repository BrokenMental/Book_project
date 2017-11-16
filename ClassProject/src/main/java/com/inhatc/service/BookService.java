package com.inhatc.service;

import java.util.List;
import com.inhatc.domain.BookVO;

public interface BookService {
	
	void regist(BookVO book)throws Exception;
	
	BookVO read(Integer no)throws Exception;
	
	void modify(BookVO book)throws Exception;
	
	void remove(Integer no)throws Exception;
	
	List<BookVO> listAll(BookVO bookVO) throws Exception;

	List<BookVO> typelist(BookVO bookVO) throws Exception;

	List<BookVO> classifylist(BookVO bookVO) throws Exception;

	List<BookVO> stypelist(BookVO bookVO) throws Exception;

}
