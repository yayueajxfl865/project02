package com.myproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.util.APIUtil;

import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UsermeServlet
 */
@WebServlet("/UsermeServlet")
public class UsermeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsermeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String query = APIUtil.user_me + "?access_token="
				+ request.getSession().getAttribute("access_token");
		JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
		String yb_userid=backJson.getJSONObject("info").getString("yb_userid");
		String yb_username=backJson.getJSONObject("info").getString("yb_username");
		String yb_usernick=backJson.getJSONObject("info").getString("yb_usernick");
		String yb_sex=backJson.getJSONObject("info").getString("yb_sex");
	     
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
