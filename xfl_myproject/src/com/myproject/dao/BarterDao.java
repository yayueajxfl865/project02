package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.entity.Barter;


public class BarterDao extends BaseDao{

	
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018  barter
	 * ����:��
	 * ����ֵ:��ѯ������Ʒ�ļ����б�
	 */
	public List<Barter> getAllProduct(String state){
		List<Barter> list=new ArrayList<Barter>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from Barter where state=?";
		
		try {
			conn=GetConn();//
			pstmt=conn.prepareStatement(sql);//
			pstmt.setString(1, state);
			rs=pstmt.executeQuery();//
			while(rs.next()){
				Barter pd=new Barter();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setStand(rs.getString("stand"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				
				list.add(pd);//
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询商品成功！");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return list;
	}
	
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:��
	 * ����ֵ:��������ѯ���е���Ʒ�����б�
	 */
	public List<Barter> getAllProductByca(String category){
	List<Barter> calist=new ArrayList<Barter>();	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from barter where category= ? and state=?";
	try{
		conn=GetConn();//�õ����ݿ����Ӷ���
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,category);
		pstmt.setString(2,"pass");
		rs=pstmt.executeQuery();//���ز�ѯ�����
	    while(rs.next()){
	    	Barter pd=new Barter();
			pd.setId(rs.getInt("Id"));
			pd.setYb_userid(rs.getString("yb_userid"));
			pd.setPname(rs.getString("pname"));
			pd.setCategory(rs.getString("category"));
			pd.setStand(rs.getString("stand"));
			pd.setPdetails(rs.getString("pdetails"));
			pd.setPicture(rs.getString("picture"));
			pd.setState(rs.getString("state"));
			calist.add(pd);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("�������鿴��Ʒʧ��!");
	}
	finally{
		CloseAll(rs,pstmt,conn);
		
	}
	
	return calist;
}
	

	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:pd
	 * ����ֵ:������˼�¼��Ӱ�������
	 * ҵ��:��ҵ��㴫�ݹ���������д�����ݿ��
	 */
	public int addProduct(Barter pd){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		//����sql
		String sql="INSERT INTO `barter`(`yb_userid`,`pname`, `category`, `stand`, `pdetails`, `picture`, `state`)  VALUES (?,?,?,?,?,?,?)";
	  
		try {
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);
			//����sql���
			pstmt.setString(1,pd.getYb_userid());
			pstmt.setString(2,pd.getPname());
			pstmt.setString(3,pd.getCategory());
			pstmt.setString(4, pd.getStand());
			pstmt.setString(5,pd.getPdetails());
			pstmt.setString(6,pd.getPicture());
			pstmt.setString(7,pd.getState());
			
			//ִ��SQL����
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("�����Ʒʧ��!");
		}finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;	
	}
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:id
	 * ����ֵ:ɾ����Ʒ��¼��Ӱ�������
	 */
	public int deleteProduct(String id){
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rows=0;
		String sql="delete from barter where id=?";
		try{
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);//�õ� Ԥ�������
			pstmt.setString(1, id);
			//ִ����Ӱ�������
			rows=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ɾ��ʧ��!");
		}
		finally{
			CloseAll(null,pstmt,conn);
		}
		return rows;
	}
	
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:id
	 * ����ֵ:����id����ָ����Ʒ��Ϣ
	 */
	public Barter getProductById(String id){
		Barter pd=new Barter();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from barter where id=?";
		try{
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();//���ز�ѯ�����
			if(rs.next()){
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setStand(rs.getString("stand"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("����id�鿴��Ʒʧ��!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return pd;
	}
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:pd
	 * ����ֵ:������Ʒ��Ϣ��Ӱ�������
	 */
	public int updateProduct(Barter pd){
			int rows=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			//����sql
			String sql="UPDATE `barter` SET `pname` = ?,`category` = ?,`stand` = ?,`pdetails` = ?,`picture` = ? WHERE `id` = ?";
		  
			try {
				conn=GetConn();//�õ����ݿ����Ӷ���
				pstmt=conn.prepareStatement(sql);
				//����sql���
				pstmt.setString(1, pd.getPname());
				pstmt.setString(2, pd.getCategory());
				pstmt.setString(3, pd.getStand());
				pstmt.setString(4,pd.getPdetails());
				pstmt.setString(5, pd.getPicture());
				
				pstmt.setInt(6, pd.getId());
			
				rows=pstmt.executeUpdate();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("修改成功！");
			}finally{
				CloseAll(null,pstmt,conn);
			}
		
		return rows;
	}
	
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:��
	 * ����ֵ:�����ѯn����Ʒ�ļ����б�
	 */
	
	public List<Barter> getRandomProduct(){
		List<Barter> rdlist=new ArrayList<Barter>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from barter order by rand() limit 3";
		
		try {
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);//ִ��dql���
			rs=pstmt.executeQuery();//���ؽ��������
			while(rs.next()){
				Barter pd=new Barter();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setStand(rs.getString("stand"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				rdlist.add(pd);//�Ѳ�ѯ����Ž���list���ϵ���
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ѯ������Ϣʧ��!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
		}
		return rdlist;
	}
	
	/**
	 * ���ߣ�Ф����
	 * ����ʱ��:2018-11-3
	 * �޸�ʱ��:2018
	 * ����:��
	 * ����ֵ:�����װ�id��ѯ���е���Ʒ�����б�
	 */
	public List<Barter> getAllProductByybid(String yb_userid){
	List<Barter> yblist=new ArrayList<Barter>();	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from barter where yb_userid= ? ";
	try{
		conn=GetConn();//�õ����ݿ����Ӷ���
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,yb_userid);
		rs=pstmt.executeQuery();//���ز�ѯ�����
	    while(rs.next()){
	    	Barter pd=new Barter();
			pd.setId(rs.getInt("Id"));
			pd.setYb_userid(rs.getString("yb_userid"));
			pd.setPname(rs.getString("pname"));
			pd.setCategory(rs.getString("category"));
			pd.setStand(rs.getString("stand"));
			pd.setPdetails(rs.getString("pdetails"));
			pd.setPicture(rs.getString("picture"));
			pd.setState(rs.getString("state"));
			yblist.add(pd);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("������Ʒ��Ų鿴��Ʒʧ��!");
	}
	finally{
		CloseAll(rs,pstmt,conn);
		
	}
	
	return yblist;
}
	
	
	
	
	
	public int updatePdState(Barter pd){
		int rows=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		//����sql
		String sql="UPDATE `barter` SET `state` = ? WHERE `id` = ?";
	  
		try {
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);
			//����sql���
			pstmt.setString(1, pd.getState());
			pstmt.setInt(2, pd.getId());
		
			rows=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("修改成功！");
		}finally{
			CloseAll(null,pstmt,conn);
		}
	
	return rows;
}
	
	
	
	public List<Barter> getAllSellpdofUser(String yb_userid){
		List<Barter> calist=new ArrayList<Barter>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from barter where yb_userid= ? and state=?";
		try{
			conn=GetConn();//�õ����ݿ����Ӷ���
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,yb_userid);
			pstmt.setString(2,"pass");
			rs=pstmt.executeQuery();//���ز�ѯ�����
		    while(rs.next()){
		    	Barter pd=new Barter();
				pd.setId(rs.getInt("Id"));
				pd.setYb_userid(rs.getString("yb_userid"));
				pd.setPname(rs.getString("pname"));
				pd.setCategory(rs.getString("category"));
				pd.setStand(rs.getString("stand"));
				pd.setPdetails(rs.getString("pdetails"));
				pd.setPicture(rs.getString("picture"));
				pd.setState(rs.getString("state"));
				calist.add(pd);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("�������鿴��Ʒʧ��!");
		}
		finally{
			CloseAll(rs,pstmt,conn);
			
		}
		
		return calist;
	}
}
