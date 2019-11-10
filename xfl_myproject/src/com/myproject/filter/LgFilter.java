
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

import com.myproject.util.*;

import cn.yiban.open.Authorize;
import cn.yiban.open.common.User;
import net.sf.json.JSONObject;

/**
 * Servlet Filter implementation class LgFilter
 */
@WebFilter("/ProcessorServlet")
public class LgFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LgFilter() {
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
		/*
		 * 此处过滤器最核心的业务只为获取授权凭证access_Token的值
		 */
		if(request.getSession().getAttribute("user")==null)
		{     //
			if(request.getParameter("code")!=null)
			{  //
				String code=request.getParameter("code");
				//request.getSession().setAttribute("code", code);
				
				Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);
				
				JSONObject json=JSONObject.fromObject(authorize.querytoken(code, AppUtil.BACKURL));
			    //通过授权的CODE获取访问令牌 应用服务器只需要请用此接口 自动处理重定向
				//此处方法为获取access_Token的值
	       
				String accessToken=json.getString("access_token");
				
				request.getSession().setAttribute("access_token", accessToken);
				
				User user=new User(accessToken);
				request.getSession().setAttribute("user", user);
			
				//request.getRequestDispatcher("ProcessorServlet").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/ProcessorServlet");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/index_entry.jsp");
			}
		}
		else {     //用户已登录,放行
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
