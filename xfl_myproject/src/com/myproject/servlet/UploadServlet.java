package com.myproject.servlet;

import java.io.File;

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

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")

@MultipartConfig(location="C:\\uploadtest")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		
	
		/*DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024);
		String tempPath=this.getServletContext().getRealPath("/temp");
		File temp=new File(tempPath);
		factory.setRepository(temp);*/

				String path=this.getServletContext().getRealPath("/images");
				//
				
				
			
				Part part=request.getPart("fileField");
				
				
				//String name=part.getName();
				
				String header=part.getHeader("Content-Disposition");
				
				//String path = header.substring(header.indexOf("filename=") + 10, header.length() - 1);
				
				
				 /*String name = UploadUtils.getRealName(path);
				 
				 String dir = UploadUtils.getDir(name);
				 String realPath = this.getServletContext().getRealPath("/upload" + dir);
				    File file = new File(realPath);
				    if (!file.exists()) {
				      file.mkdirs();
				    }*/

				int index=header.lastIndexOf("=");
		
				
				//part.getName()
	
				String file_name=header.substring(index+2, header.length()-1);
				part.write(path+"/"+file_name);
				String tmp="C:/Eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/work/Catalina/localhost/xfl_myproject/tmp";
				
				String file_tmp="@/"+tmp+"/"+file_name;
				
				
				//String file_tmp="@/tmp/"+file_name;
				

				
				//String file_tep=System.Io
				//String query = APIUtil.UPLOAD+"?access_token="+request.getSession().getAttribute("access_token")+"&file_name="+fileName
						//+"&file_tmp="+file_tmp ;
				String access_token=(String) request.getSession().getAttribute("access_token");
				
				List<NameValuePair> params=new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("access_token",access_token));
				params.add(new BasicNameValuePair("file_name",file_name));
				params.add(new BasicNameValuePair("file_tmp",file_tmp));
				
				JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.UPLOAD,params));
			
				PrintWriter out=response.getWriter();
				out.print(backJson);
				
				System.out.println("file_tmp="+file_tmp);
				//System.out.println(tmp);
				//System.out.println("name"+name);
				
			
				
				//part.write(path+"/"+fileName);
				
		doGet(request, response);
	}

}
