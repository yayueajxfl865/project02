package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.myproject.entity.User;

public class UserDao extends BaseDao{
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<User>
	 * 功能：查询数据库所有user集合列表
	 */
	public List<User> getAllUser(){
		List<User> list=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from user";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setYb_username(rs.getString("yb_username"));
				user.setYb_realname(rs.getString("yb_realname"));
				user.setYb_identity(rs.getString("yb_identity"));
				user.setYb_sex(rs.getString("yb_sex"));
				user.setYb_userhead(rs.getString("yb_userhead"));

				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：删除用户数据库所执行的行数
	 * 功能：根据数据库id删除指定的用户
	 */
	public int deleteUser(String id){
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from user where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除指定用户失败!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：User对象
	 * 功能：根据数据库id得到指定的用户对象
	 */
	public User getUserById(String id){
		User user=new User();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from user where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setYb_username(rs.getString("yb_username"));
				user.setYb_realname(rs.getString("yb_realname"));
				user.setYb_identity(rs.getString("yb_identity"));
				user.setYb_sex(rs.getString("yb_sex"));
				user.setYb_userhead(rs.getString("yb_userhead"));
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询指定用户对象失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return user;
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：user
	 * 返回值：添加用户数据库所执行的行数
	 * 功能：往数据库添加用户对象
	 */
	public int addUser(User user){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `user`(`yb_userid`, `yb_username`, `yb_realname`, `yb_identity`, `yb_sex`, `yb_userhead`)  VALUES (?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,user.getYb_userid());
			pstmt.setString(2,user.getYb_username());
			pstmt.setString(3,user.getYb_realname());
			pstmt.setString(4,user.getYb_identity());
			pstmt.setString(5,user.getYb_sex());
			pstmt.setString(6, user.getYb_userhead());
			
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("添加失败!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<User>
	 * 功能：根据易班用户id得到指定的用户集合列表
	 */
	public List<User> getAllUserByybid(String yb_userid){
		List<User> list=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from user where yb_userid=?";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				User user=new User();
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setYb_username(rs.getString("yb_username"));
				user.setYb_realname(rs.getString("yb_realname"));
				user.setYb_identity(rs.getString("yb_identity"));
				user.setYb_sex(rs.getString("yb_sex"));
				user.setYb_userhead(rs.getString("yb_userhead"));

				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询指定用户集合列表失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
	}
	
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-05
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：User对象
	 * 功能：根据易班用户id得到指定的用户对象
	 */
	
	public User getUserByybId(String yb_userid){
		User user=new User();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from user where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setYb_username(rs.getString("yb_username"));
				user.setYb_realname(rs.getString("yb_realname"));
				user.setYb_identity(rs.getString("yb_identity"));
				user.setYb_sex(rs.getString("yb_sex"));
				user.setYb_userhead(rs.getString("yb_userhead"));
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询指定用户对象失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return user;
	}
	

}
