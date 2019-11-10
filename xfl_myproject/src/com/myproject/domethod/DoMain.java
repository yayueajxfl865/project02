package com.myproject.domethod;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.myproject.util.APIUtil;

import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONObject;

public class DoMain {
	
public void remove(String client_id,String access_token) {//取消用户授权
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id",client_id));
		params.add(new BasicNameValuePair("access_token",access_token));
		
		JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.revoke_token,params));
		System.out.println(backJson);
		
	}
public String getUserme(String access_token)//从易班端获取用户名
{
	String query = APIUtil.user_me + "?access_token="
			+ access_token;
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	String usermeJson=backJson.toString();
	
	return usermeJson;
}
public String getUserrealme(String access_token)//获取用户真实姓名
{
	String query = APIUtil.user_real_me + "?access_token="
			+ access_token;
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	String userrealmeJson=backJson.toString();
	
	return userrealmeJson;
}
public void setLetter(String access_token,String to_yb_uid,String content)//向易班站内发送应用信息
{
	List<NameValuePair> params=new ArrayList<NameValuePair>();
	params.add(new BasicNameValuePair("access_token",access_token));
	params.add(new BasicNameValuePair("to_yb_uid",to_yb_uid));
	params.add(new BasicNameValuePair("content",content));
	
	
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.POST(APIUtil.msg_letter,params));
	System.out.println(backJson);


	
	
}

	
	

}
