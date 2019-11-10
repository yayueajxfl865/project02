package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * @author 肖芳林
 * @time 2018-11-10
 * 修改时间： 待定
 * 功能：定义一个数据库连接基类
 */
public class BaseDao {
	
         //JDBC连接所需参数
		 private String driver="com.mysql.jdbc.Driver";
		 private String url="jdbc:mysql://localhost:3306/xfl_mysql";
		 private String login="root";
		 private String password="nrf123";
		
		//JDBC连接对象
		public Connection GetConn(){
			Connection conn=null;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, login, password);
				System.out.println("数据库连接成功!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("数据库连接失败!");
			}
			return conn;
	}
		/**
		 * @author 肖芳林
		 * @time 2018-11-10
		 * 修改时间： 待定
		 * 功能：数据库流关闭方法法
		 */
		public void CloseAll(ResultSet rs,PreparedStatement psmt,Connection conn)
		{
			try{
				if(rs!=null)
				{
					rs.close();//关闭结果集对象
				}
				if(psmt!=null){
					psmt.close();//关闭预编译对象
				}
				if(conn!=null){
					conn.close();//关闭数据库连接对象
				}
				System.out.println("数据库流关闭成功!");
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("数据库流关闭失败!");
			}
		}
}
