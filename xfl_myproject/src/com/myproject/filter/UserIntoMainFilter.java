package com.myproject.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.domethod.Region;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;

/**
 * Servlet Filter implementation class UserIntoMainFilter
 */

public class UserIntoMainFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserIntoMainFilter() {
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
		//管理员和运营者进入后台管理系统的验证过滤器
        HttpServletRequest request=(HttpServletRequest)args1;
		
		HttpServletResponse response=(HttpServletResponse)args2;
		if(request.getSession().getAttribute("user")==null) {
			
			Region.shopRealm="intoTheMain";
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
