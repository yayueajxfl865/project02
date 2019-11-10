<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.myproject.service.*" %>
    <%@page import="java.util.List" %>
    <%@page import="com.myproject.entity.Address" %>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>地址管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
</head>


<body>
<div class="container">
            <div class="row">
               <div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/thingking/announce.jsp">首页&nbsp;&nbsp;&gt;</a>
				
					<a>失物详情</a>
				</div>
             </div>
         </div>


<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>物品发布</font>Articles issue
		
		

		
		
		<form class="form-horizontal" style="margin-top:5px;" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/GoodsServlet?method=add">
		<input type="hidden" value="n" name="kind">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">物品名字</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" placeholder="请输入物品名字" name="gName">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="phoneNumber" class="col-sm-2 control-label">丢失地点</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="phoneNumber" placeholder="请输入丢失地点" name="place">
			    </div>
			  </div>
			  
			   <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">丢失时间</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="userAddress" placeholder="请输入丢失时间" name="gtime">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">物品描述</label>
			    <div class="col-sm-6">
			      <textarea id="fa" name="describe" cols="45" rows="5" class="form-control" id="userAddress" placeholder="请输入物品描述" ></textarea>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">物品图片</label>
			    <div class="col-sm-6">
			      <input type="file" class="form-control" id="userAddress" name="photo">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系人名字</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="userAddress" placeholder="请输入联系人名字" name="realName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="userAddress" placeholder="请输入联系电话" name="phNumber">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系QQ</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="userAddress" placeholder="请输入联系QQ" name="contactqq">
			    </div>
			  </div>
		
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="提交" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/image/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
		
		
			
		
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	

		
		

</body></html>




