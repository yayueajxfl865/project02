<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>订单管理</title>
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




			<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<!--  <div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<li><a href="login.htm">登录</a></li>
						<li><a href="register.htm">注册</a></li>
						<li><a href="cart.htm">购物车</a></li>
					</ol>
				</div>
			</div>
			-->
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
            
			 
			 





<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>提交订单</font>Submission of orders
		<form class="form-horizontal" style="margin-top:5px;" method="post" action="${pageContext.request.contextPath }/AddressServlet?method=sure">
			<input type="hidden" name="idforother" value="${pd_refer.getYb_userid() }">
			<input type="hidden" name="shangpinid" value="${pd_refer.getId() }">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">收货人</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="username" value="${address.getYb_realname() }">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="phoneNumber" class="col-sm-2 control-label">手机号码</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${address.getPhoneNumber() }">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="userAddress" class="col-sm-2 control-label">收货地址</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="userAddress" name="userAddress" value="${address.getUserAddress() }">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="pname" class="col-sm-2 control-label">商品名字</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="pname" name="pname" value="${pd_refer.getPname() }">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="pnumber" class="col-sm-2 control-label">商品数量</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="pnumber" name="pnumber" value="1">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="psum" class="col-sm-2 control-label">订单总价</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="psum" name="psum" value="${pd_refer.getPrice() }">
			    </div>
			  </div>
	
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="确定购买" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/image/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/ShangPinServlet?method=intothepd&productid=${pd_refer.getId() }"><font size="10">取消</font></a>
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	

		
		

</body></html>




