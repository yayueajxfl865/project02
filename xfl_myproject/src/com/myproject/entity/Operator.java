package com.myproject.entity;


//运营者实体类,对应数据表operator
public class Operator {
	
	private int id;//数据库id
	
	
	private String yb_userid;//用户id
	private String yb_realname;//用户真实姓名名
	private String phoneNumber;//手机号码
	private String yb_sex;//性别呗
	private String yb_identity;//用户身份
	private String yb_schoolname;//所在学校
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
	public String getYb_sex() {
		return yb_sex;
	}
	public void setYb_sex(String yb_sex) {
		this.yb_sex = yb_sex;
	}
	public String getYb_identity() {
		return yb_identity;
	}
	public void setYb_identity(String yb_identity) {
		this.yb_identity = yb_identity;
	}
	public String getYb_schoolname() {
		return yb_schoolname;
	}
	public void setYb_schoolname(String yb_schoolname) {
		this.yb_schoolname = yb_schoolname;
	}
	
	
}
