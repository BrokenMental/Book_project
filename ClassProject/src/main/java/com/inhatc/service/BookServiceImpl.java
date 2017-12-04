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
	public void modify(BookVO vo) throws Exception {
		// TODO Auto-generated method stub
        System.out.println("idx1 : " + vo.getNo());
        System.out.println("sum1 : " + vo.getSum());
        System.out.println("classify1 : " + vo.getClassify());
        System.out.println("other1 : " + vo.getOther());
		dao.update(vo);
	}

	@Override
	public void remove(int no) throws Exception {
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
