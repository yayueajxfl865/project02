<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page import="com.myproject.entity.*" %>
<%@page import="com.myproject.service.*"%>
<%@page import="com.myproject.controller.servlet.*" %>
<%@page import="com.myproject.domethod.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<!-- 让IE采用最新的渲染模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 移动端的页面宽度等于设备宽度，缩放比为1 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/sidebarDemo2.css">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/shop.css">
<!--动画CSS插件-->
<link rel="stylesheet" type="text/css" href="css/animate.min.css">

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

<title>shop购物界面</title>
</head>
<script type="text/javascript">



function play()
{
	document.getElementById("modal-746102").click();
}
</script>
<body>
<%
System.out.print("shop中的验证码的值为:"+Region.log_key);

%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
  <div class="container"> 
    <!-- 当浏览器大小下于一定程度后的响应式图标-->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <!--设置商标--> 
    
      <a class="navbar-brand" href="#">校园二手交易系统</a> </div>
 
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${myuser==null }">
        <li><a href="LoginServlet?entry=shopLogin">登录</a></li>
         <li><a href="#">消息：</a></li>
      
       <li><a >您好：</a></li>
      
        </c:if>  
          
        <c:if test="${myuser!=null }"><!-- 此处的user是过滤器中保存用户登录域的user -->
        <li><a href="LoginServlet?entry=exitLogin">退出登录</a></li>
         <li><a><span id="play" onmouseover="this.style.cursor='pointer';" onclick="play();">消息:<c:if test="${yb_userid ==maijia.yb_userid}">[<font color="#FF6600">${ fn:length(message) }</font>]</c:if></span></a></li>
      
       <li><a >您好：${myuser.getYb_username() }</a></li><!-- 此处的user是ProcessorServlet中的myuser -->
      
        </c:if>
      </ul>
    </div>
    <!-- /.navbar-collapse   --> 
  </div>
  <!-- /.container-fluid --> 
  
</nav>
<div id="sidebar">
  <ul>
    <li id="prof" class="item"> <span class="glyphicon glyphicon-user"> </span>
      <div><a href="#">我</a> </div>
    </li>
    <li id="asset" class="item"> <span class="glyphicon glyphicon-usd"></span>
      <div> 资产 </div>
    </li>
    <li id="brand" class="item"> <span class="glyphicon glyphicon-heart"> </span>
      <div> 品牌 </div>
    </li>
    <li id="broadcast" class="item"> <span class="glyphicon glyphicon-bell"></span>
      <div> 直播 </div>
    </li>
    <li id="foot" class="item"> <span class="glyphicon glyphicon-eye-open"> </span>
      <div> 看过 </div>
    </li>
    <li id="calendar" class="item"> <span class="glyphicon glyphicon-time"></span>
      <div> 日历 </div>
    </li>
  </ul>
  <div id="closeBar">
    <span class="glyphicon glyphicon-remove"></span> 
  </div>
</div>

<div class="jumbotron wow slideInDown ">
  <h1>校园二手交易</h1>
  <p >让闲置游起来</p>
  <p><a class="btn btn-primary btn-lg" href="publish.jsp" role="button">发布商品</a></p>
  <div class="input-group col-sm-3"> <span class="input-group-btn ">
    <button class="btn btn-info" type="button"> 搜 索 </button>
    </span>
    <input type="text" class="form-control" placeholder="Search for...">
  </div>-->
  <!-- /input-group --> 
  
</div>

<!--秒杀板块-->
<div class="container wow slideInDown">
  <div class="row">
  
    <ul class="nav nav-tabs ">
     
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=phone" >手机数码</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=book">图书音像</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=sports">运动户外</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=computer">电脑办公</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=toys">家居玩具</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=bags">鞋靴箱包</a></li>
      <li role="presentation"><a href="/xfl_myproject/ShangPinServlet?method=ckByca&class=others">其他...</a></li>
      
    </ul>
    </br>
   
    <h1 class="wow slideInDown" data-wow-duration="1.5s">人气精选<i>Hot:</i></h1>
    </br>
    
  
 <c:forEach items="${calist}" var="sp" varStatus="status">
    
    
    
    <div class="img col-md-4 wow flash " data-wow-duration="1s" data-wow-delay="2s"> <a href="/xfl_myproject/ShangPinServlet?method=intothepd&productid=${sp.getId() }"> <img src="upload_images/${sp.getPicture() }" width="260" height="248"></a></br>
      <div class="foot_money "> <span>￥${sp.getPrice() }</span> <a href="#" class="foot_a"> <span class="glyphicon lyphicon glyphicon-heart-empty">76</span></a> </div>
      <div class="foot_title ">
        <p>${sp.getPname() }</p>
      </div>
      <div class="time text-danger"> <span class="glyphicon glyphicon-time"></span> <span id="t_d">00天</span> <span id="t_h">03时</span> <span id="t_m">11分</span> <span id="t_s">00秒</span> </div>
      <!--time 结束-->
      <button type="button" class="btn btn-danger col-md-4 col-sm-offset-2  wow flash"  data-wow-duration="1s" data-wow-delay="2s" id="daoqi">开 始 秒 杀</button>
    </div>

   </c:forEach>    
    
    
    
    
    
    
    
    
    
    
   
   
     
  </div>
  </br>
  
  </br>
</div>
</br>

<!--秒杀板块 结束--> 
<!--瀑布流布局开始-->

<!--右侧边栏-->
<div class="right_go">
  <p class="pull-right"><a href="#top">回到顶部</a></p>
</div>
<!--秒杀时间js--> 
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/waterfall.js"/></script>
<script src="js/wow.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/sidebarDemo2.js"></script>
<script>
  function GetRTime(){
       var EndTime= new Date('2018/06/28 00:00:00');//这里设置你预定的时间
       var NowTime = new Date();
       var t =EndTime.getTime() - NowTime.getTime();
       var d=Math.floor(t/1000/60/60/24);
       var h=Math.floor(t/1000/60/60%24);
       var m=Math.floor(t/1000/60%60);
       var s=Math.floor(t/1000%60);

       document.getElementById("t_d").innerHTML = d + "天";
       document.getElementById("t_h").innerHTML = h + "时";
       document.getElementById("t_m").innerHTML = m + "分";
       document.getElementById("t_s").innerHTML = s + "秒";
      
}
   setInterval(GetRTime,0);
  


</script> 
 <script>
    /*jshint expr: true */
    /*jslint evil: true */  
    window.jQuery || document.write('<script src="components/jquery/dist/jquery.min.js"><\/script>');
    </script>
<script>
$(function(){

new WOW().init();
})
</script>
</body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <a id="modal-746102" href="#modal-container-746102" role="button" class="btn" data-toggle="modal"></a>
			
			<div class="modal fade" id="modal-container-746102" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								通知
							</h4>
						</div>
						<div class="modal-body">
							<c:if test="${message==null }">无</c:if>
							<c:if test="${message!=null }">
							<c:if test="${yb_userid ==maijia.yb_userid}">
							<table  width="400" height="64" border="0" cellpadding="1" cellspacing="1">
							<tr>
							<td width="200">${message }</td>
							</tr>
							<tr>
							<td width="200"><a href="${pageContext.request.contextPath }/user?method=login">回复</a></td>
							</tr>
							</table>
							</c:if>
							</c:if>
							<c:if test="${yb_userid==to_yb_uid_other }">
							<table  width="200" height="100" border="0" cellpadding="1" cellspacing="1">
							<tr>
							<td>${content_other }</td>
							</tr>
							</table>
							</c:if>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</html>