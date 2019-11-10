package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Goods;


public class GoodsDao extends BaseDao{
	/**
	 * @author 肖芳林
	 * @time 2018-11-19
	 * 修改时间： 待定
	 * 参数 ：无
	 * 返回值：List<Goods>
	 * 功能：随机查询9件物品的集合列表
	 */
	public List<Goods> getAllGoods(){
		
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;                                                          

		String sql="select * from goods order by rand() limit 9";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Goods pd=new Goods();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setgName(rs.getString("gName"));
				pd.setPlace(rs.getString("place"));
				pd.setGtime(rs.getString("gtime"));
				pd.setDescribe(rs.getString("describe"));
				pd.setPhoto(rs.getString("photo"));
				pd.setRealName(rs.getString("realName"));
				pd.setPhNumber(rs.getString("phNumber"));
				pd.setContactqq(rs.getString("contactqq"));
				pd.setKind(rs.getString("kind"));
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
	 * @time 2018-11-19
	 * 修改时间： 待定
	 * 参数 ：pd
	 * 返回值：添加物品所执行的行数
	 * 功能：往数据库中添加物品
	 */
	
	public int addGoods(Goods pd){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO `goods`(`yb_userid`,`gName`, `place`, `gtime`, `describe`, `photo`, `realName`, `phNumber`, `contactqq`, `kind`)  VALUES (?,?,?,?,?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,pd.getYb_userid());
			pstmt.setString(2,pd.getgName());
			pstmt.setString(3,pd.getPlace());
			pstmt.setString(4,pd.getGtime());
			pstmt.setString(5,pd.getDescribe());
			pstmt.setString(6,pd.getPhoto());
			pstmt.setString(7,pd.getRealName());
			pstmt.setString(8, pd.getPhNumber());
			pstmt.setString(9, pd.getContactqq());
			pstmt.setString(10, pd.getKind());
			
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
	 * @time 2018-11-19
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：删除物品所执行的行数
	 * 功能：根据数据库id删除指定物品
	 */
	public int deleteGoods(String id){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from goods where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除失败!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}
	/**
	 * @author 肖芳林
	 * @time 2018-11-19
	 * 修改时间： 待定
	 * 参数 ：id
	 * 返回值：Goods对象
	 * 功能：根据数据库id得到指定物品
	 */
	public Goods getGoodsById(String id){
		Goods pd=new Goods();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from goods where id=?";
		try{
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setgName(rs.getString("gName"));
				pd.setPlace(rs.getString("place"));
				pd.setGtime(rs.getString("gtime"));
				pd.setDescribe(rs.getString("describe"));
				pd.setPhoto(rs.getString("photo"));
				pd.setRealName(rs.getString("realName"));
				pd.setPhNumber(rs.getString("phNumber"));
				pd.setContactqq(rs.getString("contactqq"));
				pd.setKind(rs.getString("kind"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("查询指定物品失败!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return pd;
	}
	
	/**
	 * @author 肖芳林
	 * @time 2018-11-19
	 * 修改时间： 待定
	 * 参数 ：yb_userid
	 * 返回值：List<Goods>
	 * 功能：根据易班用户id得到指定物品
	 */
	   
        public List<Goods> getAllGoodsByybid(String yb_userid){//根据易班用户id查询商品u
		
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from goods where yb_userid=?";
		
		try {
			conn=GetConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, yb_userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Goods pd=new Goods();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setgName(rs.getString("gName"));
				pd.setPlace(rs.getString("place"));
				pd.setGtime(rs.getString("gtime"));
				pd.setDescribe(rs.getString("describe"));
				pd.setPhoto(rs.getString("photo"));
				pd.setRealName(rs.getString("realName"));
				pd.setPhNumber(rs.getString("phNumber"));
				pd.setContactqq(rs.getString("contactqq"));
				pd.setKind(rs.getString("kind"));
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
    	 * @time 2018-11-19
    	 * 修改时间： 待定
    	 * 参数 ：kind
    	 * 返回值：List<Goods>
    	 * 功能：根据物品种类返回集合列表
    	 */
    public List<Goods> getAllGoodsByKind(String kind){
	
	List<Goods> list=new ArrayList<Goods>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String sql="select * from goods where kind=?";
	
	try {
		conn=GetConn();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, kind);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Goods pd=new Goods();
			pd.setId(rs.getInt("Id"));
			pd.setYb_userid(rs.getString("yb_userid"));
			pd.setgName(rs.getString("gName"));
			pd.setPlace(rs.getString("place"));
			pd.setGtime(rs.getString("gtime"));
			pd.setDescribe(rs.getString("describe"));
			pd.setPhoto(rs.getString("photo"));
			pd.setRealName(rs.getString("realName"));
			pd.setPhNumber(rs.getString("phNumber"));
			pd.setContactqq(rs.getString("contactqq"));
			pd.setKind(rs.getString("kind"));
			list.add(pd);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("根据种类查询商品列表失败！");
	}
	finally{
		CloseAll(rs,pstmt,conn);
	}
	return list;
}

}
