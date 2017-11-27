package com.inhatc.service;

import java.util.List;
import com.inhatc.domain.BookVO;

public interface BookService {
	
	void regist(BookVO book)throws Exception;
	
	List<BookVO> read(BookVO bookVO)throws Exception;
	
	void modify(BookVO book)throws Exception;
	
	void remove(int no)throws Exception;
	
	List<BookVO> listAll(BookVO bookVO) throws Exception;

	List<BookVO> typelist(BookVO bookVO) throws Exception;

	List<BookVO> classifylist(BookVO bookVO) throws Exception;

	List<BookVO> stypelist(BookVO bookVO) throws Exception;

}
