package com.myproject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Purchased;

public class PurchasedDao extends BaseDao{
	
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-27
	 * 修改时间： 待定
	 * 参数 ：pc
	 * 返回值：添加用户已购商品的记录所执行的行数数
	 * 功能：往数据库中添加用户已购商品的记录
	 */
	public int addPurchased(Purchased pc){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `purchased`(`yb_userid`,`goodsName`, `sum`)  VALUES (?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,pc.getYb_userid());
			pstmt.setString(2,pc.getGoodsName());
			pstmt.setString(3,pc.getSum());
								
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("添加记录失败!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-27
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Purchased>
	 * 功能：根据易班用户id查询用户已购商品的集合列表
	 */
	public List<Purchased> getAllPurchasedByybid(String yb_userid){
		List<Purchased> yblist=new ArrayList<Purchased>();	
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from purchased where yb_userid= ? ";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,yb_userid);
			rs=pstmt.executeQuery();
		    while(rs.next()){
		    	Purchased pc=new Purchased();
				pc.setId(rs.getInt("Id"));
				pc.setYb_userid(rs.getString("yb_userid"));
				pc.setGoodsName(rs.getString("goodsName"));
				pc.setSum(rs.getString("sum"));
				
				yblist.add(pc);
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
}
