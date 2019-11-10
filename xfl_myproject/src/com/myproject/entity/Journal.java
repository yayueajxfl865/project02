package com.myproject.entity;

public class Journal {    //个人用户日志管理实体类，对应数据表journal
	
	private String yb_userid;
	private String time;
	private String pname;
	private String type;
	public String getYb_userid() {
		return yb_userid;
	}
	public void setYb_userid(String yb_userid) {
		this.yb_userid = yb_userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
