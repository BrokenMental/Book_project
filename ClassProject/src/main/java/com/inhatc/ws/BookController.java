package com.inhatc.ws;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inhatc.domain.BookVO;
import com.inhatc.service.BookService;
import com.inhatc.util.DateUtil;

@Controller
public class BookController {

	private static final Logger Logger = LoggerFactory.getLogger(BookController.class);
	
	@Inject
	private BookService service;
	
	@RequestMapping("/")
	public String goBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
		String first_date="";
    	String last_date="";
    	
    	//first_date, last_date
    	if(StringUtils.isEmpty(BookVO.getFirst_date())) {
    		first_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setFirst_date(first_date);
    	}
    	first_date=BookVO.getFirst_date();
    	
    	if(StringUtils.isEmpty(BookVO.getLast_date())) {
    		last_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setLast_date(last_date);
    	}
    	last_date=BookVO.getLast_date();
    	
    	model.put("first_date", first_date);
        model.put("last_date", last_date);
        
        ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.read(BookVO);
    	model.put("bookList", bookList);
		
		ArrayList<BookVO> typebox = (ArrayList<BookVO>)service.typelist(BookVO);
    	model.put("typebox", typebox);
    	
    	ArrayList<BookVO> classifybox = (ArrayList<BookVO>)service.classifylist(BookVO);
    	model.put("classifybox", classifybox);
    	
    	ArrayList<BookVO> stypebox = (ArrayList<BookVO>)service.stypelist(BookVO);
    	model.put("stypebox", stypebox);
        
        System.out.println("home ....... ");
		
		return "/book/home";
	}
	
	@RequestMapping(value = "/select")
	public ModelAndView selectBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
		String first_date="";
    	String last_date="";
    	
    	//first_date, last_date
    	if(StringUtils.isEmpty(BookVO.getFirst_date())) {
    		first_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setFirst_date(first_date);
    	}
    	first_date=BookVO.getFirst_date();
    	
    	if(StringUtils.isEmpty(BookVO.getLast_date())) {
    		last_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setLast_date(last_date);
    	}
    	last_date=BookVO.getLast_date();
    	
    	model.put("first_date", first_date);
        model.put("last_date", last_date);
        
        ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.listAll(BookVO);
    	model.put("bookList", bookList);
    	
    	ArrayList<BookVO> typebox = (ArrayList<BookVO>)service.typelist(BookVO);
    	model.put("typebox", typebox);
    	
    	ArrayList<BookVO> classifybox = (ArrayList<BookVO>)service.classifylist(BookVO);
    	model.put("classifybox", classifybox);
    	
    	ArrayList<BookVO> stypebox = (ArrayList<BookVO>)service.stypelist(BookVO);
    	model.put("stypebox", stypebox);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("book/home");
    	
        System.out.println("get1 ....... ");
        
        return mav;
	
	}
	
	@RequestMapping(value = "/save")
	public ModelAndView insertBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{

        System.out.println("get0 ....... ");
		String first_date="";
    	String last_date="";
    	
    	//first_date, last_date
    	if(StringUtils.isEmpty(BookVO.getFirst_date())) {
    		first_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setFirst_date(first_date);
    	}
    	first_date=BookVO.getFirst_date();
    	
    	if(StringUtils.isEmpty(BookVO.getLast_date())) {
    		last_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setLast_date(last_date);
    	}
    	last_date=BookVO.getLast_date();
    	
    	model.put("first_date", first_date);
        model.put("last_date", last_date);
        
        service.regist(BookVO);
        
        ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.read(BookVO);
    	model.put("bookList", bookList);
        
    	ArrayList<BookVO> typebox = (ArrayList<BookVO>)service.typelist(BookVO);
    	model.put("typebox", typebox);
    	
    	ArrayList<BookVO> classifybox = (ArrayList<BookVO>)service.classifylist(BookVO);
    	model.put("classifybox", classifybox);
    	
    	ArrayList<BookVO> stypebox = (ArrayList<BookVO>)service.stypelist(BookVO);
    	model.put("stypebox", stypebox);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("book/home");
    	
        System.out.println("get1 ....... ");
        
        model.put("in_out", BookVO.getIn_out());
        model.put("sum", BookVO.getSum());
        model.put("classify",BookVO.getClassify());
        model.put("spend_type", BookVO.getSpend_type());
        model.put("other", BookVO.getOther()); 
        
        return mav;
	
	}
	
	/*@RequestMapping(value = "/delete")
	public ModelAndView deleteBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
		String first_date="";
    	String last_date="";
    	
    	//first_date, last_date
    	if(StringUtils.isEmpty(BookVO.getFirst_date())) {
    		first_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setFirst_date(first_date);
    	}
    	first_date=BookVO.getFirst_date();
    	
    	if(StringUtils.isEmpty(BookVO.getLast_date())) { 
    		last_date=DateUtil.getToday("yyyy-MM-dd");
    		BookVO.setLast_date(last_date);
    	}
    	last_date=BookVO.getLast_date();
    	
    	model.put("first_date", first_date);
        model.put("last_date", last_date);
        
        service.remove(BookVO.getNo());
        
        ArrayList<BookVO> bookList = (ArrayList<BookVO>)service.read(BookVO);
    	model.put("bookList", bookList);
        
    	ArrayList<BookVO> typebox = (ArrayList<BookVO>)service.typelist(BookVO);
    	model.put("typebox", typebox);
    	
    	ArrayList<BookVO> classifybox = (ArrayList<BookVO>)service.classifylist(BookVO);
    	model.put("classifybox", classifybox);
    	
    	ArrayList<BookVO> stypebox = (ArrayList<BookVO>)service.stypelist(BookVO);
    	model.put("stypebox", stypebox);
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("book/home");
    	
        System.out.println("get1 ....... ");
        
        model.put("in_out", BookVO.getIn_out());
        model.put("sum", BookVO.getSum());
        model.put("classify",BookVO.getClassify());
        model.put("spend_type", BookVO.getSpend_type());
        model.put("other", BookVO.getOther()); 
        
        return mav;
	
	}*/
}
