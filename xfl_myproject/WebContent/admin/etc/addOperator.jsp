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
			<li><a href="${pageContext.request.contextPath }/OperatorServlet?method=OperatorList">首页</a></li>
			<li><a href="#">添加运营者</a></li>
		</ul>
	</div>

	<form action="<%=path %>/OperatorServlet?method=addsp" method="post">
		<div class="formbody">

			<div class="formtitle">
				<span>运营者信息</span>
			</div>

			<ul class="forminfo">
				<li><label>用户id</label> <input name="yb_userid" type="text"
					class="dfinput" /><i></i></li>
				<li><label>用户姓名</label><input name="yb_realname" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i></li>
				<li><label>手机号码</label><cite><input name="phoneNumber"
						type="text" class="dfinput" value="" /></cite></li>
				<li><label>用户性别</label><input name="yb_sex" type="text"
					class="dfinput" /><i>多个关键字用,隔开</i></li>
				<li><label>用户身份</label> <input name="yb_identity" type="text"
					class="dfinput" /><i></i></li>
				<li><label>所在学校</label> <input name="yb_schoolname" type="text"
					class="dfinput" /><i></i></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="确认保存" /></li>
			</ul>


		</div>
	</form>

</body>
</html>