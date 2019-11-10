package com.myproject.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.entity.Product;
import com.myproject.entity.User;
import com.myproject.service.UserService;

/**
 * @author 肖芳林
 * @time 2018-11-21
 * 修改时间： 待定
 * 参数：method
 * 功能：易班端普通user管理Servlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		UserService userService=new UserService();
		if(method.equals("userList")) {
			List<User> List_user=userService.getAllUser();
			if(List_user.size()>0) {
				
				request.setAttribute("List_user",List_user);
				request.getRequestDispatcher("/admin/etc/userList.jsp").forward(request, response);
			}
			
		}
		else if(method.equals("queryById")){//查看指定用户
			String id=request.getParameter("otId");
		    User userbyid=userService.getUserById(id);
		 
			if(userbyid.getYb_username()!=null){
				request.setAttribute("userbyid",userbyid);
				
				request.getRequestDispatcher("/admin/etc/userchakan.jsp").forward(request, response);
				
			}
		}
		
		else if(method.equals("delete")){//删除指定用户
			String id=request.getParameter("otId");
			int rows=userService.deleteUser(id);
			if(rows>0){
				request.getRequestDispatcher("UserServlet?method=userList").forward(request, response);
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
