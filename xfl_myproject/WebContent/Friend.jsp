<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="net.sf.json.*" %>
    <%@page import="cn.yiban.util.HTTPSimple" %>
    <%@page import="com.myproject.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取用户好友页面</title>
</head>
<body>



<table align="center" border="2" cellpadding="1" cellspacing="0" width="1200" height="500">
<tr>

<td height="50">  yb_userid </td>
<td>  yb_username </td>
<td>  yb_usernick </td>
<td>  yb_sex </td>
<td>  yb_userhead </td>
<td>  yb_useractive </td>

</tr>

<tr>

<td height="50"> 好友用户id </td>
<td>   好友用户名</td>
<td>   好友用户昵称</td>
<td>   好友性别</td>
<td>  好友用户头像 </td>
<td>  好友用户在线率 </td>
</tr>

<tr>

<td height="200">
<%
String method1=request.getParameter("mymethod");
if(method1.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_userid")+"<br>") ;  
	  }
	}
}
%>



   </td>
<td>  
<%
String method2=request.getParameter("mymethod");
if(method2.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_username")+"<br>") ;  
	  }
	}
}
%>
 </td>
<td> <%
String method3=request.getParameter("mymethod");
if(method3.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_usernick")+"<br>") ;  
	  }
	}
}
%>

  </td>
<td> <%
String method4=request.getParameter("mymethod");
if(method4.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_sex")+"<br>") ;  
	  }
	}
}
%>  


</td>
<td>  <%
String method5=request.getParameter("mymethod");
if(method5.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_userhead")+"<br>") ;  
	  }
	}
}
%>


 </td>
<td>   <%
String method6=request.getParameter("mymethod");
if(method6.equals("my_friend")) {
	String query = APIUtil.ME_LIST+
			"?access_token="+request.getSession().getAttribute("access_token");
	JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
	JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("list");
	if(jsonArray.size()>0){
	  for(int i=0;i<jsonArray.size();i++){
	JSONObject job = jsonArray.getJSONObject(i);
	out.print(job.get("yb_useractive")+"<br>") ;  
	  }
	}
}
%>

</td>

</tr>

</table>
</body>
</html>