
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
			<li><a href="${pageContext.request.contextPath}/OperatorServlet?method=OperatorList">首页</a></li>
			<li><a href="#">查看运营者</a></li>
		</ul>
	</div>
	<form method="post">
		<div class="formbody">
			<div class="formtitle">
				<span>运营者信息</span>
			</div>
<ul class="forminfo">
	<li><label>用户id</label> <input name="pname" type="text" 
		value="${ot.getYb_userid() } " class="dfinput" /><i></i></li>
		
	<li><label>用户姓名</label><input name="price" type="text" 
		value="${ot.getYb_realname() } " class="dfinput" /><i>多个关键字用,隔开</i></li>
		
	<li><label>手机号码</label><cite><input name="pdetails" 
			type="text" value="${ot.getPhoneNumber() } "
			class="dfinput" value="" /></cite></li>
			
	<li><label>用户性别</label> <input name="pname" type="text" 
		value="${ot.getYb_sex() } " class="dfinput" /><i></i></li>
	
	<li><label>用户身份</label> <input name="pname" type="text" 
		value="${ot.getYb_identity() } " class="dfinput" /><i></i></li>			
	
	<li><label>所在学校</label> <input name="pname" type="text" 
		value="${ot.getYb_schoolname() } " class="dfinput" /><i></i></li>
						
	<div class="reindex">
	
	<li><a href="${pageContext.request.contextPath}/OperatorServlet?method=OperatorList" target="rightFrame">返回首页</a></li>
	</div>
</ul>
		</div>
	</form>

</body>
</html>