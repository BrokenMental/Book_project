package com.inhatc.ws;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inhatc.domain.BookVO;
import com.inhatc.service.BookService;

@Controller
public class BookController {

	@Inject
	private BookService service;
	
	@RequestMapping("/book/*")
	public String searchBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
		ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.listAll(BookVO);
    	model.put("bookList", bookList);
    	
    	BookVO.setNo(BookVO.getNo());
    	BookVO.setEnterdate(BookVO.getEnterdate());
    	BookVO.setIn_out(BookVO.getIn_out());
    	BookVO.setSum(BookVO.getSum());
    	BookVO.setClassify(BookVO.getClassify());
    	BookVO.setSpend_type(BookVO.getSpend_type());
    	BookVO.setOther(BookVO.getOther());
    	
    	model.put("no", BookVO.getNo());
    	model.put("enterdate", BookVO.getEnterdate());
    	model.put("in_out", BookVO.getIn_out());
    	model.put("sum", BookVO.getSum());
    	model.put("classify", BookVO.getClassify());
    	model.put("spend_type", BookVO.getSpend_type());
    	model.put("other", BookVO.getOther());
		
		return "/home";
	}
	
	/*
    @RequestMapping("/js/insTest.do")
	public String insertBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
    	ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.listAll(BookVO);
    	model.put("bookList", bookList);
    	
    	BookVO.setNo(BookVO.getNo());
    	BookVO.setEnterdate(BookVO.getEnterdate());
    	BookVO.setIncome(BookVO.getIncome());
    	BookVO.setSpend(BookVO.getSpend());
    	BookVO.setClassify(BookVO.getClassify());
    	BookVO.setSpend_type(BookVO.getSpend_type());
    	BookVO.setOther(BookVO.getOther());
    	
    	model.put("no", BookVO.getNo());
    	model.put("enterdate", BookVO.getEnterdate());
    	model.put("income", BookVO.getIncome());
    	model.put("spend", BookVO.getSpend());
    	model.put("classify", BookVO.getClassify());
    	model.put("spend_type", BookVO.getSpend_type());
    	model.put("other", BookVO.getOther());
    	
    	service.regist(BookVO);
    	
		return "forward:/js/test.do";
	}*/
}
