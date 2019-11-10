<%@page import="net.sf.json.JSONObject"%>
<%@page import="cn.yiban.open.common.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
<%
	User user = (User)session.getAttribute("user");//user.me()返回一个JSON，获取该JSON种的info信息
	JSONObject userInfo = JSONObject.fromObject(user.me()).getJSONObject("info");
%>


<h2 align="center">个人主页</h2>


<table align="center">
	<tr>
		<td>用户头像:</td>
		<td><img src="<%=userInfo.getString("yb_userhead")%>"></td>
		</tr>
		</table>
<br>
<table border="1" align="center" cellpadding="0" cellspacing="0" width="700">
<tr>
<td colspan="6" >登录用户信息:</td>
</tr>
	<tr>
		<td>用户ID:</td>
		<td><%=userInfo.getString("yb_userid") %></td>
		<td>用户名:</td>
		<td><%=userInfo.getString("yb_username") %></td>
		<td>用户昵称:</td>
		<td><%=userInfo.getString("yb_usernick") %></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td><%=userInfo.getString("yb_sex") %></td>
		<td>网薪数:</td>
		<td><%=userInfo.getString("yb_money") %></td>
		<td>经验值:</td>
		<td><%=userInfo.getString("yb_exp") %></td>
	</tr>
</table>
<br>
		<table border="1" align="center" cellpadding="0" cellspacing="0" width="700">
		<tr>
		<td>注册时间</td>
		<td><%=userInfo.getString("yb_regtime") %></td>
		<td>ID</td>
		<td><%=userInfo.getString("yb_schoolid") %></td>
	    <td>学校名字</td>
	    <td><%=userInfo.getString("yb_schoolname") %></td>
	</tr>
</table>

<h4>当前用户所加入公共群列表</h4>

<form action="Group.jsp" >
	<input type="hidden" name="method" value="group_public_group">
	<input type="submit" value="查看">
</form>

<h4>当前用户的好友列表</h4>
<form action="Friend.jsp">
	<input type="hidden" name="mymethod" value="my_friend">
	<input type="submit" value="查看">
</form>


</body>
</html>
