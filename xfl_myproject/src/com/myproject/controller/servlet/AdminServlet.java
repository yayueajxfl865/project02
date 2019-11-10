
package com.myproject.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.myproject.domethod.DoMain;
import com.myproject.entity.Administrators;
import com.myproject.entity.Operator;
import com.myproject.service.AdminService;
import com.myproject.util.AppUtil;

import net.sf.json.JSONObject;

/**
 * @author 肖芳林
 * @time 2018-11-19
 * 修改时间： 待定
 * 参数：method
 * 功能：管理员Servlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//指定编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		AdminService adminService=new AdminService();
		
		String method=request.getParameter("method");
		if(method.equals("AdminList")) {
			
			String access_token=(String) request.getSession().getAttribute("access_token");
			DoMain doMain=new DoMain();
		    String userJson=doMain.getUserme(access_token);
		    JSONObject mJson=JSONObject.fromObject(userJson);
		    String yb_userid=mJson.getJSONObject("info").getString("yb_userid");
		    List<Administrators> atList=adminService.getAllAdminbyybid(yb_userid);
		    int onlows=atList.size();
		    if(onlows==0) {
		    	
		    	System.out.println("你不是管理员，没有权限查看此界面！");
		    	request.getRequestDispatcher("/error_jsp/NotToAdmin.jsp").forward(request, response);		    	
		    }
		    else {
		    	
		    	List<Administrators> astorList=adminService.getAllAdmin();
				if(astorList.size()>0) {
					
					request.setAttribute("astorList", astorList);
					request.getRequestDispatcher("/admin/etc/adminList.jsp").forward(request, response);					
				}
		    }			
	}
			
			else if(method.equals("queryById")) {//根据id查看管理员
				 String id=request.getParameter("otId");
				 
				 Administrators admin=adminService.getAdminById(id);
		
				 request.setAttribute("admin",admin);
				 request.getRequestDispatcher("/admin/etc/adminchakan.jsp").forward(request, response);
			 }
		
		
			 else if(method.equals("delete")){//更换管理员
				 String id=request.getParameter("otId");
				
		         
						
						int rows=adminService.deleteAdmin(id);
						String access_token=(String) request.getSession().getAttribute("access_token");
						DoMain doMain=new DoMain();
						doMain.remove(AppUtil.AppID, access_token);
						request.getSession().invalidate();
	
						if(rows>0) {
							
							response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
							//request.getRequestDispatcher(request.getContextPath()+"/main.jsp").forward(request, response);
						}

				 
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
