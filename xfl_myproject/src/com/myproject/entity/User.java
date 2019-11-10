package com.myproject.entity;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


import com.myproject.entity.User;
//用户实体类,对应数据表user
public class User  implements HttpSessionBindingListener{
	
	private int id;//数据库id
	private String yb_userid;//易班id
	private String yb_username;//用户名 
	private String yb_realname;//真实姓名
	private String yb_identity;//用户身份
	private String yb_sex;//用户性别
	private String yb_userhead;//用户头像
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {//重写hashCode()和equals()方法
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((yb_identity == null) ? 0 : yb_identity.hashCode());
		result = prime * result + ((yb_realname == null) ? 0 : yb_realname.hashCode());
		result = prime * result + ((yb_sex == null) ? 0 : yb_sex.hashCode());
		result = prime * result + ((yb_userhead == null) ? 0 : yb_userhead.hashCode());
		result = prime * result + ((yb_userid == null) ? 0 : yb_userid.hashCode());
		result = prime * result + ((yb_username == null) ? 0 : yb_username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (yb_identity == null) {
			if (other.yb_identity != null)
				return false;
		} else if (!yb_identity.equals(other.yb_identity))
			return false;
		if (yb_realname == null) {
			if (other.yb_realname != null)
				return false;
		} else if (!yb_realname.equals(other.yb_realname))
			return false;
		if (yb_sex == null) {
			if (other.yb_sex != null)
				return false;
		} else if (!yb_sex.equals(other.yb_sex))
			return false;
		if (yb_userhead == null) {
			if (other.yb_userhead != null)
				return false;
		} else if (!yb_userhead.equals(other.yb_userhead))
			return false;
		if (yb_userid == null) {
			if (other.yb_userid != null)
				return false;
		} else if (!yb_userid.equals(other.yb_userid))
			return false;
		if (yb_username == null) {
			if (other.yb_username != null)
				return false;
		} else if (!yb_username.equals(other.yb_username))
			return false;
		return true;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYb_userid() {
		return yb_userid;
	}
	public void setYb_userid(String yb_userid) {
		this.yb_userid = yb_userid;
	}
	public String getYb_username() {
		return yb_username;
	}
	public void setYb_username(String yb_username) {
		this.yb_username = yb_username;
	}
	public String getYb_realname() {
		return yb_realname;
	}
	public void setYb_realname(String yb_realname) {
		this.yb_realname = yb_realname;
	}
	public String getYb_identity() {
		return yb_identity;
	}
	public void setYb_identity(String yb_identity) {
		this.yb_identity = yb_identity;
	}
	public String getYb_sex() {
		return yb_sex;
	}
	public void setYb_sex(String yb_sex) {
		this.yb_sex = yb_sex;
	}
	public String getYb_userhead() {
		return yb_userhead;
	}
	public void setYb_userhead(String yb_userhead) {
		this.yb_userhead = yb_userhead;
	}
	
	
	//当session和对象绑定的时候，也就是getAttribute(user的时候执行)
		public void valueBound(HttpSessionBindingEvent event) {
			System.out.println("进入了....");
			HttpSession session = event.getSession();

			Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
					.getServletContext().getAttribute("userMap");

			userMap.put(this, session);

		}

		// 当session和对象解除绑定的时候
		public void valueUnbound(HttpSessionBindingEvent event) {
			System.out.println("退出了....");
			HttpSession session = event.getSession();
			// 获得人员列表
			Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
					.getServletContext().getAttribute("userMap");
			// 将用户移除了
			userMap.remove(this);
		}

	
}
