<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path %>/admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/admin/js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="shop.jsp">首页</a></li>
			<li><a href="publish.jsp">商品发布</a></li>
			<li><a href="#">个人商品管理 </a></li>
		</ul>
	</div>

	<div class="rightinfo">

		
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>商品名称<i class="sort"><img src="<%=path %>/admin/images/px.gif" /></i></th>
					<th>所属分类</th>
					<th>商品价格</th>
					<th>商品详情</th>
					<th>商品图片</th>
					<th>商品状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

<c:forEach items="${ybList }" var="shangpin" varStatus="status">
<tr>
	<td><input name="" type="checkbox" value="" /></td>
	<td>${shangpin.getPname() }</td>
	<td>${shangpin.getCategory() }</td>
	<td>${shangpin.getPrice() }</td>
	<td>${shangpin.getPdetails() }</td>
	<td>${shangpin.getPicture() }</td>
	<td>
	<c:if test="${shangpin.getState()=='pass'}">已发布</c:if>
	<c:if test="${shangpin.getState()=='wait'}">待审核</c:if>
	</td>
	<td>
	<a href="<%=path%>/UserInpdServlet?method=queryById&pdId=${shangpin.getId() }" class="tablelink">查看</a>		
	<a href="<%=path%>/UserInpdServlet?method=update&pdId=${shangpin.getId() }" class="tablelink"> 修改</a>
	<a href="<%=path%>/UserInpdServlet?method=delete&pdId=${shangpin.getId() }" class="tablelink"> 删除</a>
	 </td>
</tr>
</c:forEach>			
	</tbody>
</table>
		


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
					
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>




	</div>

	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>