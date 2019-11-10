package com.myproject.dao;

import java.util.*;

import com.myproject.entity.Product;

import java.sql.*;


public class ShangPinDao extends BaseDao {
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：state
	 * 返回值：List<Product>
	 * 功能：根据商品状态查询商品集合列表
	 */
	public List<Product> getAllProduct(String state){
		List<Product> list=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from product where state=?";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, state);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pd=new Product();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setPrice(rs.getString("price"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				
				list.add(pd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询商品失败！");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：category
	 * 返回值：List<Product>
	 * 功能：根据商品类别查询商品集合列表
	 */
	public List<Product> getAllProductByca(String category){
	List<Product> calist=new ArrayList<Product>();	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from product where category= ? and state=?";
	try{
		conn=GetConn();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,category);
		pstmt.setString(2,"pass");
		rs=pstmt.executeQuery();
	    while(rs.next()){
			Product pd=new Product();
			pd.setId(rs.getInt("Id"));
			pd.setYb_userid(rs.getString("yb_userid"));
			pd.setPname(rs.getString("pname"));
			pd.setCategory(rs.getString("category"));
			pd.setPrice(rs.getString("price"));
			pd.setPdetails(rs.getString("pdetails"));
			pd.setPicture(rs.getString("picture"));
			pd.setState(rs.getString("state"));
			calist.add(pd);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("根据类别查询商品失败!");
	}
	finally{
		CloseAll(rs,pstmt,conn);
		
	}
	
	return calist;
}
	

	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：pd
	 * 返回值：添加商品所数据库所执行的行数数
	 * 功能：发布商品所
	 */
	public int addProduct(Product pd){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `product`(`yb_userid`,`pname`, `category`, `price`, `pdetails`, `picture`, `state`)  VALUES (?,?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,pd.getYb_userid());
			pstmt.setString(2,pd.getPname());
			pstmt.setString(3,pd.getCategory());
			pstmt.setString(4,pd.getPrice());
			pstmt.setString(5,pd.getPdetails());
			pstmt.setString(6,pd.getPicture());
			pstmt.setString(7,pd.getState());
			
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("发布商品失败!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：删除指定商品数据库所执行的行数
	 * 功能：根据数据库id删除指定商品
	 */
	public int deleteProduct(String id){
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from product where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除指定商品失败!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：Product对象
	 * 功能：根据数据库id查询指定商品
	 */
	public Product getProductById(String id){
		Product pd=new Product();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from product where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setPrice(rs.getString("price"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询指定商品失败");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return pd;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：pd
	 * 返回值：修改商品信息数据库所执行的行数
	 * 功能：修改商品信息
	 */
	public int updateProduct(Product pd){
			int rows=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			//����sql
			String sql="UPDATE `product` SET `pname` = ?,`category` = ?,`price` = ?,`pdetails` = ?,`picture` = ? WHERE `id` = ?";
		  
			try {
				conn=GetConn();
				pstmt=conn.prepareStatement(sql);
			
				pstmt.setString(1, pd.getPname());
				pstmt.setString(2, pd.getCategory());
				pstmt.setString(3, pd.getPrice());
				pstmt.setString(4,pd.getPdetails());
				pstmt.setString(5, pd.getPicture());
				
				pstmt.setInt(6, pd.getId());
			
				rows=pstmt.executeUpdate();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("修改失败！");
			}finally{
				CloseAll(null,pstmt,conn);
			}
		
		return rows;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Product>
	 * 功能：随机得到3条商品集合列表记录
	 */
	
	public List<Product> getRandomProduct(){
		List<Product> rdlist=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from product order by rand() limit 3";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pd=new Product();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setPrice(rs.getString("price"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				rdlist.add(pd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return rdlist;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Product>
	 * 功能：根据易班用户id得到指定商品信息
	 */
	public List<Product> getAllProductByybid(String yb_userid){
	List<Product> yblist=new ArrayList<Product>();	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from product where yb_userid= ? ";
	try{
		conn=GetConn();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,yb_userid);
		rs=pstmt.executeQuery();
	    while(rs.next()){
			Product pd=new Product();
			pd.setId(rs.getInt("Id"));
			pd.setYb_userid(rs.getString("yb_userid"));
			pd.setPname(rs.getString("pname"));
			pd.setCategory(rs.getString("category"));
			pd.setPrice(rs.getString("price"));
			pd.setPdetails(rs.getString("pdetails"));
			pd.setPicture(rs.getString("picture"));
			pd.setState(rs.getString("state"));
			yblist.add(pd);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("查询失败!");
	}
	finally{
		CloseAll(rs,pstmt,conn);
		
	}
	
	return yblist;
}

	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：pd
	 * 返回值：修改商品状态数据库所执行的行数
	 * 功能：修改指定商品的状态
	 */
	public int updatePdState(Product pd){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="UPDATE `product` SET `state` = ? WHERE `id` = ?";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, pd.getState());
			pstmt.setInt(2, pd.getId());
		
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("修改失败！");
		}finally{
			CloseAll(null,pstmt,conn);
		}
	
	return rows;
}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-03
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Product>
	 * 功能：根据易班用户id得到所属的商品
	 */
	
	public List<Product> getAllSellpdofUser(String yb_userid){
		List<Product> calist=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from product where yb_userid= ? and state=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,yb_userid);
			pstmt.setString(2,"pass");
			rs=pstmt.executeQuery();
		    while(rs.next()){
				Product pd=new Product();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setPrice(rs.getString("price"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				calist.add(pd);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
			
		}
		
		return calist;
	}
	
}
