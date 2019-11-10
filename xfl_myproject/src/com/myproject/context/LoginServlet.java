
package com.myproject.context;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.domethod.DoMain;
import com.myproject.domethod.Region;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;

/**
 * @author 肖芳林
 * @time 2018-11-20
 * 修改时间： 待定
 * 参数：entry
 * 功能：易班账户登录判断流向地址Servletr
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String entry=request.getParameter("entry");
		if(entry.equals("shopLogin")) {
			Region.shopRealm="shoplog";
			Region.userOnLine="indexdenglu";

		    Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);
		    String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
		    response.sendRedirect(url);

		}		   		
		else if(entry.equals("exitLogin")) {
			DoMain doMain=new DoMain();
			String access_token=(String) request.getSession().getAttribute("access_token");
			doMain.remove(AppUtil.AppID, access_token);
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/shop.jsp");
	
		}
		else if(entry.equals("existaccout")) {
			DoMain doMain=new DoMain();
			String access_token=(String) request.getSession().getAttribute("access_token");
			doMain.remove(AppUtil.AppID, access_token);
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
			
			
			
		}
		else if(entry.equals("updateTheAdmin")) {
			Region.shopRealm="updateAdminstor";
			
			Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);
			String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
			response.sendRedirect(url);
			
		}
		else if(entry.equals("AddOperator")) {
			
			Region.shopRealm="addTheOperator";
			Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);
			String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
			response.sendRedirect(url);
			
		}
		else if(entry.equals("entryaccout")) {
			
			Region.shopRealm="shoplog";
			Region.userOnLine="setAccout";

		    Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);
		    String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
		    response.sendRedirect(url);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
