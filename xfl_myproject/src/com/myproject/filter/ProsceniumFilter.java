package com.myproject.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.myproject.domethod.Region;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;

/**
 * Servlet Filter implementation class ProsceniumFilter
 */
public class ProsceniumFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ProsceniumFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest args1, ServletResponse args2, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)args1;
		HttpServletResponse response=(HttpServletResponse)args2;
		response.setContentType("text/html; charset=UTF-8");
		/*
		 * 
		 * 防止用户未经登录就访问商品发布页面
		 */
		
		if(request.getSession().getAttribute("user")==null) {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('请先登录!');window.location.href='shop.jsp';</script>");
			//response.sendRedirect(request.getContextPath()+"/shop.jsp");  
			
//	        	   Region.shopRealm="shoplog";
//	        	   Region.userOnLine="fabuProduct";
//	               System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
//	               Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);//调用易班api授权接口
//	      		   String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
//	      		   response.sendRedirect(url);
//	                  	                  
//	                     
//	           else{
//	                 response.sendRedirect(request.getContextPath()+"/shop.jsp");
//	             } 
			
			
		}
		else {
		
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
