package com.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.myproject.util.APIUtil;

import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONObject;


@WebServlet("/UploadServlet01")
@MultipartConfig(location="C:\\uploadtest",fileSizeThreshold=1024*1024*1)
public class UploadServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UploadServlet01() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Part part=request.getPart("fileField");
	
		String header=part.getHeader("Content-Disposition");
		int index=header.lastIndexOf("=");
		String file_name=header.substring(index+2, header.length()-1);
		
		part.write("C:\\Tesxt_temp_foder\\"+file_name);
		String file_tmp="@\\C:\\uploadtest\\"+file_name;
		String access_token=(String) request.getSession().getAttribute("access_token");
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("access_token",access_token));
		params.add(new BasicNameValuePair("file_name",file_name));
		params.add(new BasicNameValuePair("file_tmp",file_tmp));
		
		JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.UPLOAD,params));
		PrintWriter out=response.getWriter();
		out.print(backJson);
		
		System.out.println("file_tmp="+file_tmp);
		
	}

}
