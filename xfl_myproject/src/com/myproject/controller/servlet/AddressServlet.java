package com.myproject.controller.servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myproject.entity.Address;
import com.myproject.entity.Product;
import com.myproject.entity.Purchased;
import com.myproject.service.AddressService;
import com.myproject.service.PurchasedService;
import com.myproject.service.ShangPinService;

/**
 * @author 肖芳林
 * @time 2018-11-18
 * 修改时间： 待定
 * 参数：method
 * 功能：用户地址Servlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
	
		AddressService adrService=new AddressService();
		String method=request.getParameter("method");
		String yb_userid=(String)request.getSession().getAttribute("yb_userid");
		
		
		if(method.equals("add")) {
			String username=request.getParameter("username");
			String phoneNumber=request.getParameter("phoneNumber");
			String userAddress=request.getParameter("userAddress");
		
			Address adr=new Address();
			adr.setYb_realname(username);
			adr.setPhoneNumber(phoneNumber);
			adr.setUserAddress(userAddress);
			adr.setYb_userid(yb_userid);
			int rows=adrService.addAddress(adr);
			if(rows>0) {
				
				request.getRequestDispatcher("/publish.jsp").forward(request, response);
				
			}
			
		}
		else if(method.equals("update")) {
			
			String yb_realname=request.getParameter("username");
			String phoneNumber=request.getParameter("phoneNumber");
			String userAddress=request.getParameter("userAddress");
			Address adr=new Address();
			adr.setYb_userid(yb_userid);
			adr.setYb_realname(yb_realname);
			adr.setPhoneNumber(phoneNumber);
			adr.setUserAddress(userAddress);
			int rows=adrService.updateAddress(adr);
			if(rows>0) {
				
				request.getRequestDispatcher("/publish.jsp").forward(request, response);
			}
	
		}
		
		else if(method.equals("referTo")) {//指定商品提交订单信息页面
			String pid=request.getParameter("pid");
			System.out.println("pid="+pid);
			ShangPinService pdService=new ShangPinService();
			Product pd_refer=pdService.getProductById(pid);
			System.out.println("pd_refer="+pd_refer);
			request.setAttribute("pd_refer", pd_refer);
			
			Address address=adrService.getAddressById(yb_userid);
			request.setAttribute("address", address);
		
			request.getRequestDispatcher("/backstage_jsp/order.jsp").forward(request, response);
		}
		else if(method.equals("sure")) {
	
			String access_token=(String) request.getSession().getAttribute("access_token");
			
			String to_yb_uid_me=yb_userid;
			String to_yb_uid_other=request.getParameter("idforother");
			String username=request.getParameter("username");//收货人姓名
			String phoneNumber=request.getParameter("phoneNumber");//手机号码
			String userAddress=request.getParameter("userAddress");
			String pname=request.getParameter("pname");//商品名
			String psum=request.getParameter("psum");//交易金额
			String shangpinid=request.getParameter("shangpinid");
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=df.format(new Date());//交易时间
			
			ServletContext appSendOrderid = getServletContext();
			appSendOrderid.setAttribute("to_yb_uid_other", to_yb_uid_other);
			
			//String content_me="你好啊，你的商品";
			String content_other="您的商品："+pname+"，在 "+time+" 已被购买，交易金额为："+psum+"<br>"+"收货人:"+username+",手机号码:"+phoneNumber+",交易地址:"+userAddress;
			
			ServletContext appSendOrder = getServletContext();
			appSendOrder.setAttribute("content_other", content_other);
			
			PurchasedService pcService=new PurchasedService();
			Purchased pc=new Purchased();
			pc.setYb_userid(to_yb_uid_me);
			pc.setGoodsName(pname);
			pc.setSum(psum);
			pcService.addPurchased(pc);//把已购买成功的商品添加至数据库
					
			//DoMain doMain=new DoMain();
			ShangPinService pinService=new ShangPinService();
			pinService.deleteProduct(shangpinid);
			
			//doMain.setLetter(access_token, to_yb_uid_me, content_me);
			//doMain.setLetter(access_token, to_yb_uid_other, content_other);
			response.sendRedirect(request.getContextPath()+"/success_jsp/chechsuccess.jsp");
			//request.getRequestDispatcher("success_jsp/chechsuccess.jsp").forward(request, response);
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
