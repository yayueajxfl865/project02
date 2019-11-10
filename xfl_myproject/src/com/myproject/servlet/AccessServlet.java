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
 * Servlet implementation class AccessServlet
 */
@WebServlet("/AccessServlet")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			List<NameValuePair> params=new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("client_id",AppUtil.AppID));
			params.add(new BasicNameValuePair("client_secret",AppUtil.AppSECRET));
			params.add(new BasicNameValuePair("code",(String) request.getSession().getAttribute("code")));
			params.add(new BasicNameValuePair("redirect_uri",AppUtil.BACKURL));
			
			
			
			//String query = APIUtil.PUBLIC_GROUP+"?access_token="+request.getSession().getAttribute("access_token");
			JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.access_token, params));
			//out.print(backJson.getJSONObject("info").get("num"));
			PrintWriter out=response.getWriter();
			
			System.out.println(backJson);
			
			out.print(HTTPSimple.GET(HTTPSimple.POST(APIUtil.access_token, params)));
		
	}

}
