<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>菜单栏
	</div>

	<dl class="leftmenu">

		<dd>
<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>用户管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a  href="/xfl_myproject/AdminServlet?method=AdminList" target="rightFrame">管理员</a><i></i></li>
				<li><cite></cite><a  href="/xfl_myproject/OperatorServlet?method=OperatorList" target="rightFrame">运营者</a><i></i></li>
				<li><cite></cite><a  href="/xfl_myproject/UserServlet?method=userList" target="rightFrame">普通用户</a><i></i></li>
			</ul>
			
			
		</dd>

		



		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>商品管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="/xfl_myproject/ShangPinServlet?method=productList&spKey=pass" target="rightFrame">已上架商品</a><i></i></li>
				<li><cite></cite><a href="/xfl_myproject/ShangPinServlet?method=productList&spKey=wait" target="rightFrame">未上架商品</a><i></i></li>
			</ul>

		</dd>
		
		
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>失物招领信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a  href="${pageContext.request.contextPath }/GoodsServlet?method=goodsList&kind=n" target="rightFrame">所有失物信息</a><i></i></li>
				<li><cite></cite><a  href="${pageContext.request.contextPath }/GoodsServlet?method=goodsList&kind=y" target="rightFrame">所有招领信息</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>易置物管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="type_GetAll.action" target="rightFrame">已置换</a><i></i></li>
				<li><cite></cite><a href="type_new.jsp" target="rightFrame">未置换</a><i></i></li>
			</ul>

		</dd>
		
		
		
		
		
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>社区兴趣信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="help_new.jsp" target="rightFrame">添加</a><i></i></li>
				<li><cite></cite><a href="help_Getlisthelp.action" target="rightFrame">帮助列表</a><i></i></li>
			</ul>

		</dd>
		
		
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>通告信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="anno_new.jsp" target="rightFrame">添加</a><i></i></li>
				<li><cite></cite><a href="anno_Getlistanno.action" target="rightFrame">通告列表</a><i></i></li>
			</ul>

		</dd>

        <dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>帮助信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="help_new.jsp" target="rightFrame">添加</a><i></i></li>
				<li><cite></cite><a href="help_Getlisthelp.action" target="rightFrame">帮助列表</a><i></i></li>
			</ul>

		</dd>

	</dl>

</body>
</html>
