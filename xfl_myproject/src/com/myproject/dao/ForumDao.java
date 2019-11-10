package com.myproject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Forum;

public class ForumDao extends BaseDao{
	
	/**
	 * @author 肖芳林
	 * @time 2018-12-24
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Forum>
	 * 功能：查询数据库所有Forum集合列表
	 */
	public List<Forum> getAllForum(){
		List<Forum> list=new ArrayList<Forum>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from forum";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Forum user=new Forum();
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setContent(rs.getString("content"));
				user.setPubdate(rs.getString("pubdate"));
				user.setPhoto(rs.getString("photo"));
				user.setTheme(rs.getString("theme"));

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
	 * @time 2018-12-24
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Forum>
	 * 功能：根据易班id查询数据库所有Forum集合列表
	 */
	
	public List<Forum> getForumByybId(String yb_userid)
	{
		List<Forum> tList=new ArrayList<Forum>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from forum where yb_userid=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Forum user=new Forum();
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setContent(rs.getString("content"));
				user.setPubdate(rs.getString("pubdate"));
				user.setPhoto(rs.getString("photo"));
				user.setTheme(rs.getString("theme"));

				tList.add(user);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("根据易班用户id查询失败!");
		}
		finally{
			
			CloseAll(rs,pstmt,conn);
		}
		return tList;
    }
	/**
	 * @author 肖芳林
	 * @time 2018-12-24
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Forum>
	 * 功能：根据论坛的话题的类别查询数据库所有Forum集合列表
	 */
	public List<Forum> getForumByTopic(String theme)
	{
		List<Forum> tList=new ArrayList<Forum>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from forum where theme=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, theme);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Forum user=new Forum();
				user.setId(rs.getInt("Id"));
				user.setYb_userid(rs.getString("yb_userid"));
				user.setContent(rs.getString("content"));
				user.setPubdate(rs.getString("pubdate"));
				user.setPhoto(rs.getString("photo"));
				user.setTheme(rs.getString("theme"));

				tList.add(user);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("根据论坛话题类别查询失败!");
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
	 * 返回值：添加个人论坛
	 * 功能：添加个人论坛
	 */
	public int addForum(Forum jn) {
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `forum`(`yb_userid`, `content`, `pubdate`, `photo`, `theme`)  VALUES (?,?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1, jn.getYb_userid());
			pstmt.setString(2, jn.getContent());
			pstmt.setString(3, jn.getPubdate());
			pstmt.setString(4, jn.getPhoto());
			pstmt.setString(5, jn.getTheme());			
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("个人论坛写入数据库失败!");
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
	 * 返回值：删除个人论坛执行的行数
	 * 功能：根据数据库id删除指定论坛话题
	*/
	
	public int deleteForum(String id){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from forum where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除个人论坛失败！");
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
	 * 返回值：ot
	 * 功能：根据id得到个人论坛执行的行数
	*/
	public Forum getForumById(String id){
		Forum ot=new Forum();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from forum where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				ot.setId(rs.getInt("Id"));
				ot.setYb_userid(rs.getString("yb_userid"));
				ot.setContent(rs.getString("content"));
				ot.setPubdate(rs.getString("pubdate"));
				ot.setPhoto(rs.getString("photo"));
				ot.setTheme(rs.getString("theme"));
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

}
