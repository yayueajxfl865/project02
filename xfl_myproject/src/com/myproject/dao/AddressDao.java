package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Address;

public class AddressDao extends BaseDao{
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-25
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：Address对象
	 * 功能：通过id查询指定用户的地址
	 */
	public Address getAddressById(String yb_userid)
	{
		Address adr=new Address();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from address where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				adr.setId(rs.getInt("Id"));
				adr.setYb_userid(rs.getString("yb_userid"));
				adr.setYb_realname(rs.getString("yb_realname"));
				adr.setPhoneNumber(rs.getString("phoneNumber"));
				adr.setUserAddress(rs.getString("userAddress"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("根据id查询指定用户地址失败");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return adr;
}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-25
	 * 修改时间： 待定
	 * 参数 ：adr
	 * 返回值：执行数据库添加操作所受影响的行数的
	 * 功能：添加所有用户的地址
	 */
	public int addAddress(Address adr) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `address`(`yb_userid`, `yb_realname`, `phoneNumber`, `userAddress`)  VALUES (?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, adr.getYb_userid());
			pstmt.setString(2, adr.getYb_realname());
			pstmt.setString(3, adr.getPhoneNumber());
			pstmt.setString(4, adr.getUserAddress());
			
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("添加用户地址失败！");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	

	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-25
	 * 修改时间： 待定
	 * 参数 ：dbr
	 * 返回值：删除指定用户地址记录所影响的行数数
	 * 功能：删除指定用户地址
	 */
	public int updateAddress(Address adr)
	{
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="UPDATE `address` SET `yb_realname` = ?,`phoneNumber` = ?,`userAddress` = ? WHERE `yb_userid` = ?";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, adr.getYb_realname());
			pstmt.setString(2, adr.getPhoneNumber());
			pstmt.setString(3, adr.getUserAddress());
			pstmt.setString(4, adr.getYb_userid());
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除指定用户地址失败！");
		}finally{
			CloseAll(null,pstmt,conn);
		}
	
	    return rows;
		
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-25
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Address>
	 * 功能：通过易班用户id查询所有用户地址的集合
	 */
	public List<Address> getAddressByybId(String yb_userid)
	{
		
		List<Address> list=new ArrayList<Address>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from address where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Address adr=new Address();
				adr.setId(rs.getInt("Id"));
				adr.setYb_userid(rs.getString("yb_userid"));
				adr.setYb_realname(rs.getString("yb_realname"));
				adr.setPhoneNumber(rs.getString("phoneNumber"));
				adr.setUserAddress(rs.getString("userAddress"));
				list.add(adr);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("根据易班用户id查询用户地址失败！");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
}
	
}
