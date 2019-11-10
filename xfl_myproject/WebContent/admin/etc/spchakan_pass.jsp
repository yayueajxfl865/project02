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
			<li><a href="<%=path %>/ShangPinServlet?method=productList&spKey=pass">首页</a></li>
			<li><a href="#">查看商品</a></li>
		</ul>
	</div>
	<form method="post">
		<div class="formbody">
			<div class="formtitle">
				<span>记账信息</span>
			</div>
<ul class="forminfo">
	<li><label>商品名称</label> <input name="pname" type="text" disabled="disabled"
		value="${pdinfor.getPname() } " class="dfinput" /><i>多个关键字用,隔开</i></li>
		
	<li><label>所属分类</label><input name="price" type="text" disabled="disabled"
		value="${pdinfor.getCategory() } " class="dfinput" /><i></i></li>	
		
	<li><label>价格</label><input name="price" type="text" disabled="disabled"
		value="${pdinfor.getPrice() } " class="dfinput" /><i></i></li>
		
	<li><label>商品详情</label><cite><input name="pdetails" disabled="disabled"
			type="text" value="${pdinfor.getPdetails() } "
			class="dfinput" value="" /></cite></li>
			
	<li><label>商品图片</label><input type="image" name="picture" id="picture" disabled="disabled" width="200" height="200" src="upload_images/${pdinfor.getPicture()}"/><i></i></li>
		
	<div class="reindex">
	
	<li><a href="ShangPinServlet?method=productList&spKey=pass" target="rightFrame">返回首页</a></li>
</ul>
		</div>
	</form>

</body>
</html>