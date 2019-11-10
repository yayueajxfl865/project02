package com.myproject.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.myproject.entity.Administrators;
import com.myproject.service.AdminService;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;

/**
 * Servlet Filter implementation class AdminIntoFilter
 */

public class AdminIntoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminIntoFilter() {
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

		/*
		 * 管理员首次登录验证的过滤器 ，添加第一个管理员
		 * 
		 */
        HttpServletRequest request=(HttpServletRequest)args1;
		
		HttpServletResponse response=(HttpServletResponse)args2;
		response.setContentType("text/html; charset=UTF-8");
		AdminService adminService=new AdminService();
		List<Administrators> adminList=adminService.getAllAdmin();
		if(adminList.size()==0) {

	               Region.shopRealm="adminIntotheMain";
	   			
	   		       Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);//�����װ�api��Ȩ�ӿ�
	   		       String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
	   		       response.sendRedirect(url);
	               
	               
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
