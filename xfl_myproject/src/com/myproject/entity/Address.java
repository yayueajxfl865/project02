package com.myproject.entity;

public class Address {       //个人用户地址管理实体类
	
	private int id;
	private String yb_userid;
	private String yb_realname;
	private String phoneNumber;
	private String userAddress;
	public int getId() {
		return id;
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
	public String getYb_realname() {
		return yb_realname;
	}
	public void setYb_realname(String yb_realname) {
		this.yb_realname = yb_realname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
	

}
