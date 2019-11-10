package com.myproject.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.util.APIUtil;


import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String real_path="/我的图片";
			
		
		String method_num = request.getParameter("download");
		if(method_num.equals("download_me")) {
			String query = APIUtil.DOWNLOAD+"?access_token="+request.getSession().getAttribute("access_token")+"&dir_path="+real_path;
			JSONObject backJson_download = JSONObject.fromObject(HTTPSimple.GET(query));
			//out.print(backJson.getJSONObject("info").get("num"));
			System.out.println(backJson_download);
			JSONArray jsonArray = backJson_download.getJSONObject("info").getJSONArray("file");
			System.out.println(jsonArray);
			JSONObject job = jsonArray.getJSONObject(1);			
			
			String download_url=job.getString("download_url");
			System.out.println(download_url);			
				
			java.net.URI uri;
			try {
				uri = new java.net.URI(download_url);
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			//response.sendRedirect(download_url);
			
//			if(jsonArray.size()>0){
//			  for(int i=0;i<jsonArray.size();i++){
//			JSONObject job = jsonArray.getJSONObject(i);
//			out.print(job.get("group_id")+"<br>") ;  
//			  }
//			}
			
			//request.getSession().setAttribute("backJson_download", backJson_download);
//			PrintWriter out=response.getWriter();
//			out.print(backJson_download);
			//System.out.println(backJson_download);   
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
