package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Operator;



public class OperatorDao extends BaseDao{
	/**
	 * @author 肖芳林
	 * @time 2018-11-15
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Operator>
	 * 功能：得到所有的运营者集合列表
	 */
	public List<Operator> getAllOperator(){
		List<Operator> list=new ArrayList<Operator>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from operator";
		
		try {
			conn=GetConn();//获得数据库连接对象
			pstmt=conn.prepareStatement(sql);//获得预编译对象
			rs=pstmt.executeQuery();//返回结果集对象
			while(rs.next()){
				Operator ot=new Operator();
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setPhoneNumber(rs.getString("phoneNumber"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
	
				list.add(ot);//把Product对象放进List集合中
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询运营者列表失败");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-15
	 * 修改时间： 待定
	 * 参数 ：ot
	 * 返回值：添加运营者执行的行数
	 * 功能：添加运营者
	 */
	
	public int addOperator(Operator ot){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		//sql编写
		String sql="INSERT INTO `operator`(`yb_userid`, `yb_realname`, `phoneNumber`, `yb_sex`, `yb_identity`, `yb_schoolname`)  VALUES (?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();//获得数据库连接对象
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1,ot.getYb_userid());
			pstmt.setString(2,ot.getYb_realname());
			pstmt.setString(3,ot.getPhoneNumber());
			pstmt.setString(4,ot.getYb_sex());
			pstmt.setString(5,ot.getYb_identity());
			pstmt.setString(6, ot.getYb_schoolname());
		
			//执行sql语句
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("添加运营者失败");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-15
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：删除指定运营者执行的行数
	 * 功能：根据数据库id删除指定运营者
	 */
	public int deleteOperator(String id){
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from operator where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除运营者失败！");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-15
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：Operator对象
	 * 功能：根据数据库id得到指定的运营者
	 */
	public Operator getOperatorById(String id){
		Operator ot=new Operator();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from operator where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setPhoneNumber(rs.getString("phoneNumber"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
			
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return ot;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-15
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Operator>
	 * 功能：根据易班用户id得到指定的运营者集合列表合
	 */
	public List<Operator> getAllOperatorbyybid(String yb_userid){
		List<Operator> loglist=new ArrayList<Operator>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from operator where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Operator ot=new Operator();
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setYb_realname(rs.getString("yb_realname"));
				ot.setPhoneNumber(rs.getString("phoneNumber"));
				ot.setYb_sex(rs.getString("yb_sex"));
				ot.setYb_identity(rs.getString("yb_identity"));
				ot.setYb_schoolname(rs.getString("yb_schoolname"));
				
				loglist.add(ot);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询运营者列表失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return loglist;
	}
	

}
