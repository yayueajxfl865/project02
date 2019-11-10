package com.myproject.entity;

public class Purchased {   //已购商品实体类
	
	
	private int id;
	
	private String yb_userid;
	private String goodsName;
	private String sum;
	
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}

}
