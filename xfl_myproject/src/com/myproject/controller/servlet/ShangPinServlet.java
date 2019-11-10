package com.myproject.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.myproject.domethod.DoMain;
import com.myproject.domethod.Docategory;
import com.myproject.domethod.Region;
import com.myproject.entity.Journal;
import com.myproject.entity.Product;
import com.myproject.entity.User;
import com.myproject.service.*;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;





/**
 * @author 肖芳林
 * @time 2018-11-10
 * 修改时间： 待定
 * 参数：method
 * 功能：商品Servlet
 */
@WebServlet("/ShangPinServlet")
@MultipartConfig
public class ShangPinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShangPinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String savepath=this.getServletContext().getRealPath("upload_images");
		
		/**
		 * 获取请求验证参数method
		 */
		String method=request.getParameter("method");
		
		ShangPinService pdService=new ShangPinService();
		
		if(method.equals("productList")){//
			String key=request.getParameter("spKey");
			List<Product> list=pdService.getAllProduct(key);
			request.setAttribute("splist", list);
			
			if(key.equals("pass"))
			{
				
				request.getRequestDispatcher("/admin/etc/spList_pass.jsp").forward(request, response);
			}else if(key.equals("wait")) {
				request.getRequestDispatcher("/admin/etc/spList.jsp").forward(request, response);
			}
			
			
		}
		else if(method.equals("addsp")){//发布商品
			 
			 /*
		      * 基于Servlet3.0规范的文件上传，核心类Part类
			  */
				
			Part part=request.getPart("picture");
				/*
				 *获取文件域中的请求头参数列表和解析请求
				 */
			String header=part.getHeader("Content-Disposition");
			int index=header.lastIndexOf("=");
			String file_name=header.substring(index+2, header.length()-1);
			part.write(savepath+"/"+file_name);
			 
			String yb_userid=(String)request.getSession().getAttribute("yb_userid"); 
			String pname=request.getParameter("pname");//商品名称
			String category=request.getParameter("dept");//商品类别
			String price=request.getParameter("price");//商品价格格
			String pdetails=request.getParameter("pdetails");//商品详情情
			String picture_path=file_name;//商品图片原始文件名
			
			String state="wait";//初始化商品状态
		
			Product pd=new Product();
			pd.setYb_userid(yb_userid);
			pd.setPname(pname);
			pd.setCategory(category);
		
			pd.setPrice(price);
			pd.setPdetails(pdetails);
			pd.setPicture(picture_path);
			pd.setState(state);
			
			int rows=pdService.addProduct(pd);
			if(rows>0){
				/*
				 * 商品发布日志写入数据库
				 */
				
				JournalService jnService=new JournalService();
				Journal jn=new Journal();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//发布时间
				String time=df.format(new Date());
				String type="发布";
				jn.setPname(pname);
				jn.setType(type);
				jn.setYb_userid(yb_userid);
				jn.setTime(time);
				jnService.addDaily(jn);
				
				
			
				//request.getRequestDispatcher("shop.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/shop.jsp");
			}
		
				//request.getRequestDispatcher("ShangPinServlet?flag=list").forward(request, response);
	    }
		else if(method.equals("queryById")){//根据id查看指定未审核商品
			String id=request.getParameter("pdId");
		    Product pdinfor=pdService.getProductById(id);
		 
			if(pdinfor.getPname()!=null){
				request.setAttribute("pdinfor",pdinfor);
				
				request.getRequestDispatcher("/admin/etc/spchakan.jsp").forward(request, response);
				
			}
		}
		
		else if(method.equals("queryById_pass")){
			String id=request.getParameter("pdId");
		    Product pdinfor=pdService.getProductById(id);
		 
			if(pdinfor.getPname()!=null){
				request.setAttribute("pdinfor",pdinfor);
				
				request.getRequestDispatcher("/admin/etc/spchakan_pass.jsp").forward(request, response);
				
			}
		}
		else if(method.equals("update")){
			String userId=request.getParameter("pdId");		
			
			Product pd=pdService.getProductById(userId);
			if(pd.getPname()!=null){
				request.setAttribute("pd", pd);
				request.getRequestDispatcher("/admin/etc/spupdate.jsp").forward(request, response);
			}
			
		}
		else if(method.equals("onUpdate")){
			String pdId=request.getParameter("pdId");
			String pname=request.getParameter("pname");
			String category=request.getParameter("category");
			String price=request.getParameter("price");
			String pdetails=request.getParameter("pdetails");
			String picture=request.getParameter("picture");
			
			Product pd=new Product();
			
			int id=Integer.valueOf(pdId);
			pd.setId(id);
			pd.setPname(pname);
			
			pd.setCategory(category);
		
		    pd.setPrice(price);
			pd.setPdetails(pdetails);
			pd.setPicture(picture);		
			int rows=pdService.updateProduct(pd);
			System.out.println(id);
			System.out.println(rows);
			if(rows>0){
				request.getRequestDispatcher("ShangPinServlet?method=productList&spKey=wait").forward(request, response);
			}
			
		}
		else if(method.equals("delete")){//删除指定商品
			String id=request.getParameter("pdId");
			int rows=pdService.deleteProduct(id);
			if(rows>0){
				request.getRequestDispatcher("ShangPinServlet?method=productList&spKey=wait").forward(request, response);
			}
		}
		else if(method.equals("delete_pass")){//删除指定已审核的商品delete_pass
			String id=request.getParameter("pdId");
			int rows=pdService.deleteProduct(id);
			if(rows>0){
				request.getRequestDispatcher("ShangPinServlet?method=productList&spKey=pass").forward(request, response);
			}
		}
		else if(method.equals("ckByca")) {//根据类别查询商品
			String key=request.getParameter("class");
			Docategory ca=new Docategory();
			String leibie=ca.getCategory(key);
		
			List<Product> calist=pdService.getAllProductByca(leibie);
		
		    request.setAttribute("calist", calist);
		
			request.getRequestDispatcher("/shop.jsp").forward(request, response);
			
		}
		
		
		else if (method.equals("intothepd"))// 从shop页面进入指定的商品页面
		{

			if (request.getSession().getAttribute("user") == null) {

				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('请先登录!');window.location.href='shop.jsp'</script>");
				//response.sendRedirect(request.getContextPath() + "/shop.jsp");
			}

			else {

				String productid = request.getParameter("productid");

				Product getshangpbyidOnchaty = pdService.getProductById(productid);

				request.setAttribute("getshangpbyidOnchaty", getshangpbyidOnchaty);

				UserService userService = new UserService();

				User maijia = userService.getUserByybId(getshangpbyidOnchaty.getYb_userid());

				ServletContext apt = getServletContext();

				apt.setAttribute("maijia", maijia);

				request.getRequestDispatcher("/backstage_jsp/product_info.jsp").forward(request, response);

			}
		}
		
		else if(method.equals("ExitTheSystem")) {//退出后台管理系统
			 String access_token=(String) request.getSession().getAttribute("access_token");
		     DoMain doMain=new DoMain();
		     doMain.remove(AppUtil.AppID, access_token);
		     request.getSession().invalidate();//手动清除所有Session域

			 PrintWriter out = response.getWriter();
			 out.print("<script language='javascript'>alert('欢迎下次光临!');window.location.href='admin/etc/error.jsp'</script>");
	          
			      
			       //response.sendRedirect(request.getContextPath()+"/admin/etc/error.jsp");
	          
	           
		}
		
		else if(method.equals("updatePdInState")) {//修改商品状态
			
			String upId=request.getParameter("upId");
			int id=Integer.valueOf(upId);
			String state="pass";
			Product pd=new Product();
			pd.setId(id);
			pd.setState(state);
			int rows=pdService.updatePdState(pd);
			if(rows>0) {
				
				request.getRequestDispatcher("ShangPinServlet?method=productList&spKey=wait").forward(request, response);
				
			}
			
		}
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
