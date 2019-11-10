package com.myproject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Journal;

public class JournalDao extends BaseDao{
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-18
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Journal>
	 * 功能：根据易班用户id返回用户日志列表
	 */
	public List<Journal> getDailyByybId(String yb_userid)
	{
		List<Journal> tList=new ArrayList<Journal>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from journal where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Journal jn=new Journal();
				jn.setYb_userid(rs.getString("yb_userid"));
				jn.setTime(rs.getString("time"));
				jn.setPname(rs.getString("pname"));
				jn.setType(rs.getString("type"));
				tList.add(jn);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询日志失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return tList;
}
	/**
	 * @author 肖芳林
	 * @time 2018-11-18
	 * 修改时间： 待定
	 * 参数 ：jn
	 * 返回值：添加个人日志所执行的行数
	 * 功能：添加个人日志
	 */
	public int addDaily(Journal jn) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `journal`(`yb_userid`, `time`, `pname`, `type`)  VALUES (?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1, jn.getYb_userid());
			pstmt.setString(2, jn.getTime());
			pstmt.setString(3, jn.getPname());
			pstmt.setString(4, jn.getType());
			
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("日志写入数据库失败!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	

	}
	
	
	
	
	

}
