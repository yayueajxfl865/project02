
package com.myproject.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.myproject.domethod.Region;

/**
 * Servlet Filter implementation class IntoTheshopFilter
 */
public class IntoTheshopFilter implements Filter {
	
	

    /**
     * Default constructor. 
     */
    public IntoTheshopFilter() {
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
	     * 失物招领过滤器
	     */
	    if(request.getSession().getAttribute("user")==null) {
	    	
	    	
	    	PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('请先登录!');window.location.href='announce.jsp';</script>");
	    	
	    	
			//response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
	    	
	    }
	    else {
	    	chain.doFilter(request, response);
	    }
	
	    
   }
	private ServletContext getServletContext() {
		
		return null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
