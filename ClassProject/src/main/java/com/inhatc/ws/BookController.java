package com.inhatc.ws;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    		first_date="----------";
    		BookVO.setFirst_date(first_date);
    	}
    	first_date=BookVO.getFirst_date();
    	
    	if(StringUtils.isEmpty(BookVO.getLast_date())) {
    		last_date="----------";
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

    	first_date="----------";
    	BookVO.setFirst_date(first_date);
        first_date=BookVO.getFirst_date();

    	last_date="----------";
    	BookVO.setLast_date(last_date);
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
        
        return mav;
	
	}
	
	@RequestMapping(value = "/update/{idx}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> updateBook(@PathVariable("idx") Integer idx, @RequestBody BookVO vo) throws Exception{
        
        ResponseEntity<String> entity = null;
        try {
        	vo.setNo(idx);
        	
            System.out.println("idx : " + vo.getNo());
            System.out.println("sum : " + vo.getSum());
            System.out.println("classify : " + vo.getClassify());
            System.out.println("other : " + vo.getOther());
        	service.modify(vo);
        	entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }catch(Exception e) {
        	e.printStackTrace();
        	entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        System.out.println("update......");        
        return entity;
	
	}
	
	@RequestMapping(value = "/delete/{idx}")
	public ResponseEntity<String> deleteBook(@PathVariable("idx") Integer idx) throws Exception{
        
        System.out.println("idx : " + idx);
        
        ResponseEntity<String> entity = null;
        try {
        	service.remove(idx);
        	entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }catch(Exception e) {
        	e.printStackTrace();
        	entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        System.out.println("delete......");        
        return entity;
	
	}
	
	@RequestMapping(value = "/deleteall")
	public ModelAndView deleteallBook(@ModelAttribute BookVO BookVO, ModelMap model, HttpServletRequest request) throws Exception{
		
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
        
		String checkRow = request.getParameter("checkRow");
		System.out.println(checkRow);
		String checkRowArray[] = checkRow.split(",");
		
		for(int i = 0; i<checkRowArray.length; i++) {
			BookVO.setNo(Integer.parseInt(checkRowArray[i]));
			int no = Integer.parseInt(checkRowArray[i]);
			service.remove(no);
		}
		
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
    	
        System.out.println("get5 ....... ");
        
        return mav;
	
	}
}
