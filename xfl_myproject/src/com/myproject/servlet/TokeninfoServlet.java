package com.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.myproject.util.APIUtil;
import com.myproject.util.AppUtil;

import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class TokeninfoServlet
 */
@WebServlet("/TokeninfoServlet")
public class TokeninfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokeninfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("utf-8");
	
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id",AppUtil.AppID));
		params.add(new BasicNameValuePair("access_token",(String) request.getSession().getAttribute("access_token")));
	
		
			//String query = APIUtil.TOKEN_INFO+"?client_id="+AppUtil.AppID+"&access_token="+request.getSession().getAttribute("access_token");
			JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.TOKEN_INFO, params));
			//out.print(backJson.getJSONObject("info").get("num"));
			PrintWriter out=response.getWriter();
			out.print(backJson);
			//System.out.println(HTTPSimple.GET(HTTPSimple.POST(APIUtil.TOKEN_INFO, params)));
		doGet(request, response);
	}
	
}
