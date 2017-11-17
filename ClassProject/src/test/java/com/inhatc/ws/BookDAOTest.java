package com.inhatc.ws;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.BookVO;
import com.inhatc.persistence.BookDAO;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BookDAOTest {

	@Inject
	private BookDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BookDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		
		BookVO book = new BookVO();
		book.setIn_out("지출");
		book.setSum(10000);
		book.setClassify("식비");
		book.setSpend_type("현금");
		dao.create(book);
	}
	
	/*
	@Test
	public void testRead() throws Exception {
		 
		logger.info(dao.read(1).toString());
	}

	@Test
	public void testUpdate() throws Exception {
		
		BookVO book = new BookVO();
		book.setNo(1);
		book.setIn_out("수입");
		book.setSum(11000);
		book.setClassify("용돈/기타");
		book.setSpend_type("현금");
		dao.update(book);
	}
	*/
	@Test
	public void testDelete() throws Exception {
		
		dao.delete(4);
	}
}
