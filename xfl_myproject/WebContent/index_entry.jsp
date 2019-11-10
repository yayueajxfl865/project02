<%@page import="cn.yiban.open.Authorize"%>
<%@page import="com.myproject.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>易班授权</title>
</head>
<body>

<%


    //调用AppUtil中的数据来跳转到指定的获取授权地址
    Authorize authorize=new Authorize(AppUtil.AppID,AppUtil.AppSECRET);//调用易班api授权接口
    String url=authorize.forwardurl(AppUtil.BACKURL, null,Authorize.DISPLAY_TAG_T.WEB);
    response.sendRedirect(url);//授权认证的URL地址，此操作浏览器重定向到该地址进行授权请求
    //请求参数会携带授权码令牌code
%>
</body>
</html>