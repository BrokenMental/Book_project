package com.inhatc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.inhatc.domain.BookVO;
import com.inhatc.persistence.BookDAO;

@Service
public class BookServiceImpl implements BookService {
	
	@Inject
	private BookDAO dao;

	@Override
	public void regist(BookVO book) throws Exception {
		// TODO Auto-generated method stub
		dao.create(book);
		
	}

	@Override
	public void modify(BookVO book) throws Exception {
		// TODO Auto-generated method stub
		dao.update(book);
	}

	@Override
	public void remove(Integer no) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(no);
	}

	@Override
	public List<BookVO> listAll(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll(bookVO);
	}

	@Override
	public List<BookVO> typelist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.typelist(bookVO);
	}

	@Override
	public List<BookVO> classifylist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.classifylist(bookVO);
	}

	@Override
	public List<BookVO> stypelist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.stypelist(bookVO);
	}

	@Override
	public List<BookVO> read(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bookVO);
	}


}
