package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Administrators;
import com.myproject.entity.Operator;

public class AdminDao extends BaseDao{
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-22
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Administrators>
	 * 功能：通过易班用户id查询管理员的集合列表
	 */
	public List<Administrators> getAllAdminbyybid(String yb_userid){
		List<Administrators> adminlist=new ArrayList<Administrators>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from administrators where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Administrators ot=new Administrators();
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setYb_username(rs.getString("yb_username"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
				ot.setYb_userhead(rs.getString("yb_userhead"));
				adminlist.add(ot);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询管理员列表失败！");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return adminlist;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-22
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Administrators>
	 * 功能：直接查询管理员的集合列表
	 */
	public List<Administrators> getAllAdmin(){
		List<Administrators> atorlist=new ArrayList<Administrators>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from administrators";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Administrators ot=new Administrators();
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setYb_username(rs.getString("yb_username"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
				ot.setYb_userhead(rs.getString("yb_userhead"));
				
				atorlist.add(ot);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询管理员列表失败！");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return atorlist;
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-22
	 * 修改时间： 待定
	 * 参数 ：ot
	 * 返回值：往数据库中添加管理员所受影响的行数
	 * 功能：往数据库中写入管理员记录入
	 */
	
	public int addAdmin(Administrators ot){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		//����sql
		String sql="INSERT INTO `administrators`(`yb_userid`, `yb_realname`, `yb_username`, `yb_sex`, `yb_identity`, `yb_schoolname`, `yb_userhead`)  VALUES (?,?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,ot.getYb_userid());
			pstmt.setString(2,ot.getYb_realname());
			pstmt.setString(3,ot.getYb_username());
			pstmt.setString(4,ot.getYb_sex());
			pstmt.setString(5,ot.getYb_identity());
			pstmt.setString(6, ot.getYb_schoolname());
			pstmt.setString(7, ot.getYb_userhead());
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("添加管理员失败!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-22
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：Administrators对象
	 * 功能：通过数据库id查询管理员
	 */
	public Administrators getAdminById(String id){
		Administrators ot=new Administrators();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from administrators where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setYb_username(rs.getString("yb_username"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
				ot.setYb_userhead(rs.getString("yb_userhead"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("根据id查询管理员失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return ot;
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-22
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：删除管理员所执行的行数
	 * 功能：通过数据库id删除管理员
	 */
	public int deleteAdmin(String id){
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from administrators where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除管理员失败!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}

}
