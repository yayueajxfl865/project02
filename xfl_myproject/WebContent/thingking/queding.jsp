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
<%
String yb_userid=(String)request.getSession().getAttribute("yb_userid");
AddressService adrService=new AddressService();
List<Address> adrList=adrService.getAddressByybId(yb_userid);
int isexist =adrList.size();
request.setAttribute("isexist", isexist);

if(isexist>0){
	
	Address secadr=adrService.getAddressById(yb_userid);
	request.setAttribute("secadr", secadr);
	
}
%>
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
		<font>请主动联系：</font>Please contact
		
		<form class="form-horizontal" style="margin-top:5px;" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/thingking/announce.jsp">
		
		
		<div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">物品名</label>
			    <div class="col-sm-6">
			      <input type="text" value="${gs.gName }" class="form-control" id="userAddress" name="realName">
			    </div>
			  </div>
	  			  
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系人</label>
			    <div class="col-sm-6">
			      <input type="text" value="${gs.realName }" class="form-control" id="userAddress" name="realName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-6">
			      <input type="text" value="${gs.phNumber }" class="form-control" id="userAddress" name="phNumber">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">联系QQ</label>
			    <div class="col-sm-6">
			      <input type="text" value="${gs.contactqq }" class="form-control" id="userAddress" name="contactqq">
			    </div>
			  </div>
		
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="确定" name="submit" border="0"
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




