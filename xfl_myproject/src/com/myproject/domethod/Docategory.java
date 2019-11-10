package com.myproject.domethod;

public class Docategory {//商品类别请求参数
	
	public String getCategory(String key)
	{
		
		String valus="";
		if(key.equals("phone"))
		{
			valus="手机数码";
		}
		else if(key.equals("book"))
		{
			valus="图书音像";
		}
		else if(key.equals("sports"))
		{
			valus="运动户外";
		}
		else if(key.equals("computer"))
		{
			valus="电脑办公";
		}
		else if(key.equals("toys"))
		{
			valus="家居玩具";
		}
		else if(key.equals("bags"))
		{
			valus="鞋靴箱包";
		}
		else if(key.equals("others")) {
			valus="其他";
		}
		return valus;
		
		
	}

}
