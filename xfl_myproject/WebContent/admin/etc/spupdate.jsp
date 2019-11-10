<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
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
			<li><a href="<%=path %>/ShangPinServlet?method=productList&spKey=wait">首页</a></li>
			<li><a href="#">修改商品</a></li>
		</ul>
	</div>

<form action="<%=path %>/ShangPinServlet?method=onUpdate&pdId=${pd.getId() }" method="post">
		<div class="formbody">
			<div class="formtitle">
				<span>基本信息</span>
			</div>
			<ul class="forminfo">
				<li><label>商品名称</label> <input name="pname" type="text"
					value="${pd.getPname() }" class="dfinput" /><i>多个关键字用,隔开</i></li>
					
					<li><label>所属分类</label> <input name="category" type="text"
					value="${pd.getCategory() }" class="dfinput" /><i></i></li>
					
				<li><label>商品价格</label><input name="price" type="text"
					value="${pd.getPrice() }" class="dfinput" /><i></i></li>
					
				<li><label>商品详情</label><cite><input name="pdetails"
						type="text" value="${pd.getPdetails() }"
						class="dfinput" value="" /></cite></li>
						
				<li><label>商品图片</label><input name="picture" type="text"
					value="${pd.getPicture() }" class="dfinput" /><i></i></li>
		
				<div class="reindex">
				<li><label></label><input name="" type="submit"
					class="btn" value="确认保存" /></li>
			</ul>
		</div>
	</form>

</body>
</html>