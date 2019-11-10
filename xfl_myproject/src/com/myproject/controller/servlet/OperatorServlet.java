package com.myproject.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.domethod.DoMain;
import com.myproject.entity.Administrators;
import com.myproject.entity.Operator;
import com.myproject.entity.Product;
import com.myproject.service.AdminService;
import com.myproject.service.OperatorService;
import com.myproject.util.AppUtil;

import net.sf.json.JSONObject;

/**
 * @author 肖芳林
 * @time 2018-11-12
 * 修改时间： 待定
 * 参数：method
 * 功能：运营者Servlet
 */
@WebServlet("/OperatorServlet")
public class OperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//指定编码方式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		 String method=request.getParameter("method");//获得请求列表参数
		
		 
		 OperatorService otService=new OperatorService();
		 
		 if(method.equals("OperatorList")){//运营者列表
				
			 
			    String access_token=(String) request.getSession().getAttribute("access_token");
				DoMain doMain=new DoMain();
			    String userJson=doMain.getUserme(access_token);
			    JSONObject mJson=JSONObject.fromObject(userJson);
			    String yb_userid=mJson.getJSONObject("info").getString("yb_userid");
			    AdminService adminService=new AdminService();			
			    List<Administrators> atList=adminService.getAllAdminbyybid(yb_userid);
			    int onlows=atList.size();
			    if(onlows==0) {
			    	
			    	System.out.println("你不是管理员，没有权限查看此界面！");
			    	request.getRequestDispatcher("/error_jsp/NotToAdmin.jsp").forward(request, response);
			    	
			    }
			    else {
			    	
			    	    List<Operator> list=otService.getAllOperator();
						
					    request.getSession().setAttribute("otlist", list);
					    request.getRequestDispatcher("/admin/etc/operatorlist.jsp").forward(request, response);			    			    	
			    }
		}

		 
		 else if(method.equals("addsp")){//添加运营者
			
			 String yb_userid=request.getParameter("yb_userid");
			 String yb_realname=request.getParameter("yb_realname");
			 String phoneNumber=request.getParameter("phoneNumber");
			 String yb_sex=request.getParameter("yb_sex");
			 String yb_identity=request.getParameter("yb_identity");
			 String yb_schoolname=request.getParameter("yb_schoolname");

			 Operator ot=new Operator();
			 ot.setYb_userid(yb_userid);
			 ot.setYb_realname(yb_realname);
			 ot.setPhoneNumber(phoneNumber);
			 ot.setYb_sex(yb_sex);
			 ot.setYb_identity(yb_identity);
			 ot.setYb_schoolname(yb_schoolname);

			 int rows=otService.addOperator(ot);
				if(rows>0){
					System.out.println("运营者添加成功!");				   
					request.getRequestDispatcher("OperatorServlet?method=OperatorList").forward(request, response);
				}
			 	
			 
		 }
		 
		 else if(method.equals("delete")){//删除指定的运营者
				String id=request.getParameter("otId");
				int rows=otService.deleteOperator(id);
				if(rows>0){
					request.getRequestDispatcher("OperatorServlet?method=OperatorList").forward(request, response);
				}
			}
		 else if(method.equals("queryById")) {//根据id查看指定运营者
			 String id=request.getParameter("otId");
			 
			 Operator ot=otService.getOperatorById(id);
			 request.setAttribute("ot",ot);
			 request.getRequestDispatcher("/admin/etc/operatorchakan.jsp").forward(request, response);
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
