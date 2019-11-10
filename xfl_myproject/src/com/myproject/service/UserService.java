package com.myproject.service;

import java.util.List;


import com.myproject.dao.UserDao;
import com.myproject.entity.User;

/*����:Ф����
 * ����ʱ��:2018-11-06
 * �޸�ʱ��:
 *����:ҵ���м�� (Service��)
 */
public class UserService {
	private UserDao userDao=new UserDao();
	
	public List<User> getAllUser(){
		return userDao.getAllUser();
		
	}
	
	public int deleteUser(String id) {
		
		return userDao.deleteUser(id);
	}
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}
	public int addUser(User user) {
		return userDao.addUser(user);
	}
	public List<User> getAllUserByybid(String yb_userid){
		
		return userDao.getAllUserByybid(yb_userid);
	}
	public User getUserByybId(String yb_userid){
		
		return userDao.getUserByybId(yb_userid);
	}

}
