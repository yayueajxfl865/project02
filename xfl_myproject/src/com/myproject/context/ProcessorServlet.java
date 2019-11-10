
package com.myproject.context;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.domethod.DoMain;
import com.myproject.domethod.Region;
import com.myproject.entity.Administrators;
import com.myproject.entity.Operator;
import com.myproject.entity.User;
import com.myproject.service.AdminService;
import com.myproject.service.OperatorService;
import com.myproject.service.UserService;
import com.myproject.util.AppUtil;

import net.sf.json.JSONObject;

/**
 * @author 肖芳林
 * @time 2018-11-20
 * 修改时间： 待定
 * 参数：Region.shopRealm,Region.userOnLine(不受重定向域影响的静态参数)
 * 功能：易班账户登录成功后的回调地址Servlet
 */
@WebServlet("/ProcessorServlet")
public class ProcessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessorServlet() {
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
		
		
		String access_token=(String) request.getSession().getAttribute("access_token");
		
		System.out.println("Region.shopRealm="+Region.shopRealm);
		
		//shop.jsp普通user登录的验证以及把普通user的数据写入数据库
		if(Region.shopRealm.equals("shoplog"))
		{
			System.out.println("第一个是"+Region.shopRealm);
			Region.shopRealm="";
		
			UserService userService=new UserService();

		    DoMain doMain=new DoMain();
		    String userJson=doMain.getUserme(access_token);
		    JSONObject mJson=JSONObject.fromObject(userJson);
		    String yb_username=mJson.getJSONObject("info").getString("yb_username");
		    
		    User myuser=new User();
		    myuser.setYb_username(yb_username);
		    
		    String yb_userid=mJson.getJSONObject("info").getString("yb_userid");
		    request.getSession().setAttribute("yb_userid", yb_userid);
		    List<User> list=userService.getAllUserByybid(yb_userid);
		    
		    
		    if(list.size()==0) {
		    	
		   
		    String realJson=doMain.getUserrealme(access_token);
		    JSONObject nJson=JSONObject.fromObject(realJson);
		    
		    
		    
		    String yb_realname=nJson.getJSONObject("info").getString("yb_realname");
		    String yb_identity=nJson.getJSONObject("info").getString("yb_identity");
		    String yb_sex=mJson.getJSONObject("info").getString("yb_sex");
		    String yb_userhead=mJson.getJSONObject("info").getString("yb_userhead");
		    
		    
		    myuser.setYb_userid(yb_userid);
		    
		    myuser.setYb_realname(yb_realname);
		    myuser.setYb_identity(yb_identity);
		    myuser.setYb_sex(yb_sex);
		    myuser.setYb_userhead(yb_userhead);
		    
		    
		    userService.addUser(myuser);
	}    
	
		    request.getSession().setAttribute("myuser", myuser);
		    
		 if(Region.userOnLine.equals("indexdenglu"))   {//shop页面请求登录后转向shop.jsp
			 Region.userOnLine="";
			 response.sendRedirect(request.getContextPath()+"/shop.jsp");
			 
		 }
		 else if(Region.userOnLine.equals("fabuProduct")) {//shop页面请求登录后转向publish.jsp商品发布页面
			
			 Region.userOnLine="";
			 response.sendRedirect(request.getContextPath()+"/publish.jsp");
			 
		 }
		 else if(Region.userOnLine.equals("setAccout")) {
			 Region.userOnLine="";
			 response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
			 
		 }
		 
		 
		 
		 else if(Region.userOnLine.equals("userToProduct")) {
			 request.getRequestDispatcher("backstage_jsp/product_info.jsp").forward(request, response);
			 
		 }	    	    		 
  }

		
		//管理员首次登录系统以及需要更换管理员的验证 
		else if(Region.shopRealm.equals("adminIntotheMain")) {
			
			 Region.shopRealm="";
		
             DoMain daoMain=new DoMain();
	
			 String usermeJson=daoMain.getUserme(access_token);
			 
			 String userrealJson=daoMain.getUserrealme(access_token);
	
			
			 JSONObject backJson_userrealme=JSONObject.fromObject(userrealJson);
		
			 JSONObject backJson_userme = JSONObject.fromObject(usermeJson);
			
			 
			 String yb_userid=backJson_userme.getJSONObject("info").getString("yb_userid");
			 String yb_realname=backJson_userrealme.getJSONObject("info").getString("yb_realname");
			 String yb_username=backJson_userme.getJSONObject("info").getString("yb_username");
			 String yb_sex=backJson_userme.getJSONObject("info").getString("yb_sex");
			 String yb_identity=backJson_userrealme.getJSONObject("info").getString("yb_identity");
			 String yb_schoolname=backJson_userme.getJSONObject("info").getString("yb_schoolname");
			 String yb_userhead=backJson_userme.getJSONObject("info").getString("yb_userhead");	
			 
			 Administrators ot=new Administrators();
			 ot.setYb_userid(yb_userid);
			 ot.setYb_realname(yb_realname);
			 ot.setYb_username(yb_username);
			 ot.setYb_sex(yb_sex);
			 ot.setYb_identity(yb_identity);
			 ot.setYb_schoolname(yb_schoolname);
			 ot.setYb_userhead(yb_userhead);
			 AdminService adminService=new AdminService();
			 int rows=adminService.addAdmin(ot);
			 if(rows>0) {
				
				 response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
			
		}
	
	}
		//管理员和运营者进入后台管理系统的验证
		else if(Region.shopRealm.equals("intoTheMain")) {	
			
			 Region.shopRealm="";
			 DoMain daoMain=new DoMain();
				
			 
			 String usermeJson=daoMain.getUserme(access_token);
			
			 JSONObject backJson_userme = JSONObject.fromObject(usermeJson);
			 
			 String yb_userid=backJson_userme.getJSONObject("info").getString("yb_userid");
			
			 System.out.println("yb_userid"+yb_userid);
			 
			 OperatorService otService=new OperatorService();
			 List<Operator> otList=otService.getAllOperatorbyybid(yb_userid);
			 
			 int otonLine=otList.size();		
			
			 AdminService adminService=new AdminService();
			 
			 List<Administrators> adminList=adminService.getAllAdminbyybid(yb_userid);
						 
			 int adminonLine=adminList.size();
			 
			 System.out.println("adminonLine"+adminonLine);
			 
			 if(otonLine>0||adminonLine>0) {
				
				// request.getRequestDispatcher("/main.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
			 }
			 else {
				 
				 DoMain doMain=new DoMain();
				 doMain.remove(AppUtil.AppID, access_token);
				 request.getSession().invalidate();
				 
				 PrintWriter out = response.getWriter();
				 out.print("<script language='javascript'>alert('您没有权限进入系统!');window.location.href='shop.jsp'</script>");
				
				 //response.sendRedirect(request.getContextPath()+"/shop.jsp");
			 }
		}
		else if(Region.shopRealm.equals("updateAdminstor")) {
			
			 Region.shopRealm="";
			
             DoMain daoMain=new DoMain();
	
			 String usermeJson=daoMain.getUserme(access_token);
			 
			 String userrealJson=daoMain.getUserrealme(access_token);
	
			
			 JSONObject backJson_userrealme=JSONObject.fromObject(userrealJson);
		
			 JSONObject backJson_userme = JSONObject.fromObject(usermeJson);
			
			 
			 String yb_userid=backJson_userme.getJSONObject("info").getString("yb_userid");
			 String yb_realname=backJson_userrealme.getJSONObject("info").getString("yb_realname");
			 String yb_username=backJson_userme.getJSONObject("info").getString("yb_username");
			 String yb_sex=backJson_userme.getJSONObject("info").getString("yb_sex");
			 String yb_identity=backJson_userrealme.getJSONObject("info").getString("yb_identity");
			 String yb_schoolname=backJson_userme.getJSONObject("info").getString("yb_schoolname");
			 String yb_userhead=backJson_userme.getJSONObject("info").getString("yb_userhead");	
			 
			 Administrators ot=new Administrators();
			 ot.setYb_userid(yb_userid);
			 ot.setYb_realname(yb_realname);
			 ot.setYb_username(yb_username);
			 ot.setYb_sex(yb_sex);
			 ot.setYb_identity(yb_identity);
			 ot.setYb_schoolname(yb_schoolname);
			 ot.setYb_userhead(yb_userhead);
			 AdminService adminService=new AdminService();
			 int rows=adminService.addAdmin(ot);
			 if(rows>0) {
				 
				 request.getRequestDispatcher("AdminServlet?method=AdminList").forward(request, response);
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
