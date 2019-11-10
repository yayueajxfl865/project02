
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<%String savepath=this.getServletContext().getRealPath("upload_images"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=path %>/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=path %>/GoodsServlet?method=goodsList&kind=n">首页</a></li>
			<li><a href="#">查看用户</a></li>
		</ul>
	</div>
	<form method="post">
		<div class="formbody">
			<div class="formtitle">
				<span>用户信息</span>
			</div>
<ul class="forminfo">
	<li><label>用户id</label> <input name="pname" type="text" 
		value="${goodsByid.yb_userid } " class="dfinput" /><i></i></li>
		
	<li><label>用户姓名</label><input name="price" type="text" 
		value="${goodsByid.realName } " class="dfinput" /><i>多个关键字用,隔开</i></li>
		
	<li><label>手机号码</label><cite><input name="pdetails" 
			type="text" value="${goodsByid.phNumber } "
			class="dfinput" value="" /></cite></li>
			
	<li><label>联系QQ</label> <input name="pname" type="text" 
		value="${goodsByid.contactqq } " class="dfinput" /><i></i></li>
	
	<li><label>物品名称</label> <input name="pname" type="text" 
		value="${goodsByid.gName } " class="dfinput" /><i></i></li>			
	
	<li><label>丢失地点</label> <input name="pname" type="text" 
		value="${goodsByid.place } " class="dfinput" /><i></i></li>
		
	<li><label>丢失时间</label> <input name="pname" type="text" 
		value="${goodsByid.gtime } " class="dfinput" /><i></i></li>
		
		<li><label>物品描述</label> <input name="pname" type="text" 
		value="${goodsByid.describe } " class="dfinput" /><i></i></li>
				
	<li><label>物品图片</label><input type="image" name="picture" id="picture"  width="200" height="200" src="<%=path %>/account_images/${goodsByid.photo}"/><i></i></li>
		
	<div class="reindex">
	
	<li><a href="GoodsServlet?method=goodsList&kind=n" target="rightFrame">返回首页</a></li>
	</div>
</ul>
		</div>
	</form>

</body>
</html>