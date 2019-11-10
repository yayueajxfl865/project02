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
			<li><a href="#">已购买商品</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>用户id<i class="sort"><img src="<%=path %>/admin/images/px.gif" /></i></th>
					<th>商品名称</th>
					<th>交易价格</th>
										
				</tr>
			</thead>
			<tbody>

<c:forEach items="${alredyGetList }" var="shangpin" varStatus="status">
<tr>
	<td><input name="" type="checkbox" value="" /></td>
	<td>${shangpin.getYb_userid() }</td>
	<td>${shangpin.getGoodsName() }</td>
	<td>${shangpin.getSum() }</td>

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