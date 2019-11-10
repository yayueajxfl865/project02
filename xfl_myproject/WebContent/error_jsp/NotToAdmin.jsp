<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path %>/admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/admin/js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script>


</head>
<body>
<body style="background: #f2f9fd;">

	

	<div class="error">

		<h2>您没有权限查看此界面！</h2>
		<p>欢迎下次使用</p>
		

	</div>
</body>
</html>