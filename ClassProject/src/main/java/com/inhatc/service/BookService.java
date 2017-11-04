package com.inhatc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inhatc.domain.BookVO;
import com.inhatc.persistence.BookDAO;

public interface BookService {
	
	void regist(BookVO book)throws Exception;
	
	BookVO read(Integer no)throws Exception;
	
	void modify(BookVO book)throws Exception;
	
	void remove(Integer no)throws Exception;
	
	List<BookVO> listAll(BookVO bookVO) throws Exception;

}
