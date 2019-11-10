package com.myproject.service;

import java.util.List;

import com.myproject.dao.AdminDao;
import com.myproject.entity.Administrators;

public class AdminService {
	
	private AdminDao adminDao=new AdminDao();
	
	public List<Administrators> getAllAdminbyybid(String yb_userid){
		
		return adminDao.getAllAdminbyybid(yb_userid);
	}
	
	public List<Administrators> getAllAdmin(){
		
		return adminDao.getAllAdmin();
	}
	
	public int addAdmin(Administrators ot){
		return adminDao.addAdmin(ot);
	}
	public Administrators getAdminById(String id){
		
		return adminDao.getAdminById(id);
	}
	
	public int deleteAdmin(String id){
		
		return adminDao.deleteAdmin(id);
	}

}
