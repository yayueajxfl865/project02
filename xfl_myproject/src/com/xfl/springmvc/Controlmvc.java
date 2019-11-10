package com.xfl.springmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlmvc {
	@RequestMapping(value="/interAll")
	public String visitAll() {
		
		
		System.out.println("成功访问论坛主页面!");
		return "all";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,Map<String,Object> map) {
		String top=request.getParameter("top");//主题
		String theme=request.getParameter("theme");//分类
		String special=request.getParameter("special");//专题
		String content=request.getParameter("content");//详情
		String yb_userid="201216";
		String pubdate="2018-1-11";
		String photo="im.jpg";
		int forward=0;
		int comment=0;
		int praise=0;
		
	
	
		
		
		return "all";
	}
	
	

}
