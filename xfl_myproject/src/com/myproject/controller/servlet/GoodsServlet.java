package com.myproject.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.myproject.domethod.Region;
import com.myproject.entity.Goods;
import com.myproject.service.GoodsService;
import com.myproject.util.AppUtil;

import cn.yiban.open.Authorize;

/**
 * @author 肖芳林
 * @time 2018-11-18
 * 修改时间： 待定
 * 参数：method
 * 功能：失物招领Servlet
 */
@WebServlet("/GoodsServlet")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
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
		
		GoodsService goodsService=new GoodsService();
		String yb_userid=(String)request.getSession().getAttribute("yb_userid");
	
		String method=request.getParameter("method");
		
		if(method.equals("goodsList")) {
			String kind=request.getParameter("kind");

			List<Goods> gsList=goodsService.getAllGoodsByKind(kind);
			request.setAttribute("gsList", gsList);
			if(kind.equals("y")) {
			request.getRequestDispatcher("/admin/etc/goodslist.jsp").forward(request, response);
			}
			else if(kind.equals("n")) {
				request.getRequestDispatcher("/admin/etc/goodslist_set.jsp").forward(request, response);
			}

		}
		else if(method.equals("delete")) {//后台管理系统删除物品信息
			
			String id=request.getParameter("otId");
			int rows=goodsService.deleteGoods(id);
			if(rows>0) {
				request.getRequestDispatcher("GoodsServlet?method=goodsList&kind=y").forward(request, response);
			}
						
		}
		
		else if(method.equals("queryById")) {//后台管理系统根据id查看物品信息
			String id=request.getParameter("otId");
			Goods goodsByid=goodsService.getGoodsById(id);
			request.setAttribute("goodsByid", goodsByid);
			request.getRequestDispatcher("/admin/etc/goodschakan.jsp").forward(request, response);
		}
		
		
        else if(method.equals("deletes")) {//后台管理系统删除物品信息
			
			String id=request.getParameter("otId");
			int rows=goodsService.deleteGoods(id);
			if(rows>0) {
				request.getRequestDispatcher("GoodsServlet?method=goodsList&kind=n").forward(request, response);
			}
						
		}
		
		else if(method.equals("queryByIds")) {//后台管理系统根据id查看物品信息
			String id=request.getParameter("otId");
			Goods goodsByid=goodsService.getGoodsById(id);
			request.setAttribute("goodsByid", goodsByid);
			request.getRequestDispatcher("/admin/etc/goodslistchakna_set.jsp").forward(request, response);
		}
		
		
		else if(method.equals("add")) {
		String savepath=this.getServletContext().getRealPath("account_images");
		
		
		Part part=request.getPart("photo");
		/*
		 *解析上传文件请求头
		 */
	    String header=part.getHeader("Content-Disposition");
	    int index=header.lastIndexOf("=");
	    String file_name=header.substring(index+2, header.length()-1);
	    part.write(savepath+"/"+file_name);//将文件写入服务器指定文件夹内
		
	    
		
		String gName=request.getParameter("gName");
		String place=request.getParameter("place");
		String gtime=request.getParameter("gtime");
		String describe=request.getParameter("describe");
		String photo=file_name;
		String realName=request.getParameter("realName");
		String phNumber=request.getParameter("phNumber");
		String contactqq=request.getParameter("contactqq");
		String kind=request.getParameter("kind");
		
		Goods goods=new Goods();
		goods.setYb_userid(yb_userid);
		goods.setgName(gName);
		goods.setPlace(place);
		goods.setGtime(gtime);
		goods.setDescribe(describe);
		goods.setPhoto(photo);
		goods.setRealName(realName);
		goods.setPhNumber(phNumber);
		goods.setContactqq(contactqq);
		goods.setKind(kind);
		
		int rows=goodsService.addGoods(goods);
		if(rows>0)
		{
			//request.getRequestDispatcher("GoodsServlet?method=goodsList").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
		}

   }
		
		else if(method.equals("getThewuping")) {
			if(request.getSession().getAttribute("user")==null) {
		
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('请先登录!');window.location.href='thingking/announce.jsp'</script>");
				//response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
			}
			else {
				String wpid=request.getParameter("wpid");
				
		          
		        	   Goods gs=goodsService.getGoodsById(wpid);
		        	   request.setAttribute("gs", gs);
		        	   request.getRequestDispatcher("thingking/queding.jsp").forward(request, response);

			}
			
		}
		else if(method.equals("wpbyUser")) {
			
			if(request.getSession().getAttribute("user")==null) {
				
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('请先登录!');window.location.href='thingking/announce.jsp'</script>");
				//response.sendRedirect(request.getContextPath()+"/thingking/announce.jsp");
			}
			
			else {
			    List<Goods> goodsbyuser_list=goodsService.getAllGoodsByybid(yb_userid);
			    System.out.println("goodsbyuser_list+"+goodsbyuser_list);
			    request.setAttribute("goodsbyuser_list", goodsbyuser_list);
			    request.getRequestDispatcher("/thingking/wpList.jsp").forward(request, response);
			}
		
		}
		
		
		else if(method.equals("deleteOnUser"))
		{
			String id=request.getParameter("deid");
			int rows=goodsService.deleteGoods(id);
			request.getRequestDispatcher("/thingking/announce.jsp").forward(request, response);
		}
		else if(method.equals("enquire")) {
			String kind=request.getParameter("kind");
			System.out.println("kind"+kind);
			List<Goods> kindList=goodsService.getAllGoodsByKind(kind);
			//System.out.println("kind="+kindList);
			request.setAttribute("kindList", kindList);
			if(kind.equals("y")) {
				request.getRequestDispatcher("/thingking/getpage.jsp").forward(request, response);
			}
			else if(kind.equals("n")) {
				request.getRequestDispatcher("/thingking/setpage.jsp").forward(request, response);
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
