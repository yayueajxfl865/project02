package com.myproject.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.entity.Product;
import com.myproject.entity.Purchased;
import com.myproject.service.PurchasedService;
import com.myproject.service.ShangPinService;

/**
 * @author 肖芳林
 * @time 2018-11-21
 * 修改时间： 待定
 * 参数：method
 * 功能：个人用户管理Servlet
 */
@WebServlet("/UserInpdServlet")
public class UserInpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInpdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String yb_userid=(String)request.getSession().getAttribute("yb_userid");
		ShangPinService pdService=new ShangPinService();
		
		String method=request.getParameter("method");//个人商品管理
		if(method.equals("getpdByid")) {
			List<Product> ybList=pdService.getAllProductByybid(yb_userid);
			
			request.setAttribute("ybList", ybList);
			request.getRequestDispatcher("/backstage_jsp/pdbyuser.jsp").forward(request, response);
			
		}
		
		else if(method.equals("queryById")){//根据id查看商品
			String id=request.getParameter("pdId");
		    Product pd=pdService.getProductById(id);
		 
			if(pd.getPname()!=null){
				request.setAttribute("pd",pd);
				
				request.getRequestDispatcher("/backstage_jsp/userTopdlook.jsp").forward(request, response);
				
			}
		}
		else if(method.equals("update")){//修改商品信息
			String userId=request.getParameter("pdId");		
			
			Product pd=pdService.getProductById(userId);
			if(pd.getPname()!=null){
				request.setAttribute("pd", pd);
				request.getRequestDispatcher("/backstage_jsp/userTopdupdate.jsp").forward(request, response);
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
				request.getRequestDispatcher("UserInpdServlet?method=getpdByid").forward(request, response);
			}
			
		}
		else if(method.equals("delete")){//删除个人商品
			String id=request.getParameter("pdId");
			int rows=pdService.deleteProduct(id);
			if(rows>0){
				request.getRequestDispatcher("UserInpdServlet?method=getpdByid").forward(request, response);
			}
		}
		else if(method.equals("alreadySell")) {
			
			
			List<Product> alSellList=pdService.getAllSellpdofUser(yb_userid);
			request.setAttribute("alSellList", alSellList);
			
			request.getRequestDispatcher("/backstage_jsp/sellofUser.jsp").forward(request, response);
		}
		else if(method.equals("alreadyPurchased")) {
			PurchasedService pc=new PurchasedService();
			List<Purchased> alredyGetList=pc.getAllPurchasedByybid(yb_userid);
			request.setAttribute("alredyGetList", alredyGetList);
			request.getRequestDispatcher("/backstage_jsp/PurchasedPd.jsp").forward(request, response);
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
