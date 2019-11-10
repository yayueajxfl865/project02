<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="com.myproject.entity.Product" %>
<%@page import="com.myproject.service.*" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index主界面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--自己定义的样式-->
<link rel="stylesheet" type="text/css" href="css/index.css">
<!--动画CSS插件-->
<link rel="stylesheet" type="text/css" href="css/animate.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/wow.min.js"></script>
<!--jquery单页面导航插件-->
</head>
<%
String access_token=(String) request.getSession().getAttribute("access_token");
System.out.println("输出当前的access_token值为："+access_token);
System.out.println("输出当前的access_token值为："+access_token);
System.out.println("输出当前的access_token值为："+access_token);


ShangPinService pdService=new ShangPinService();

List<Product> rdlist=pdService.getRandomProduct();

request.getSession().setAttribute("rdlist", rdlist);
System.out.println("当前的集合为："+rdlist);

%>

<body>
<!-- 顶部导航 navbar-fixed-top置顶 导航条不遮蔽内容 并且一直显示 需要在body中设置 padding-top70px; -->
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
  <div class="container"> 
    <!-- 当浏览器大小下于一定程度后的响应式图标-->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <!--设置商标--> 
      <a class="navbar-brand" href="#">工院易生活</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
       
       
        <li><a href="#" data-toggle="modal" data-target="#about">关于</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<!-- 广告轮播  -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> 
  <!-- 导航index -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
  
  <!-- 轮播组件的内容-->
  <div class="carousel-inner wow lightSpeedIn" role="listbox">
    <div class="item active"> <img src="images/computer.jpg"  alt="carousel_1"/> </div>
    <div class="item"> <img src="images/323080.jpg"   alt="carousel_2"/> </div>
    <div class="item"> <img src="images/book.jpg" width="600" height="427"  alt="carousel_3"/> </div>
  </div>
  
  <!-- 向左向右的按钮 --> 
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span> </a> </div>
<hr class="feature-divider">

<!-- 主要内容 -->
<div class="container summary"> 
  
  <!-- 简介 -->
  <div class="row wow fadeInDown" data-wow-duration="3s" data-wow-delay="1s" id="summary-container">
     <div class="col-md-4"> <img class="img-circle" src="images/b7.png" alt="">
      <h2>二手市场</h2>
      <p><a class="btn btn-primary btn-lg col-sm-offset-4 col-md-4" href="${pageContext.request.contextPath }/shop.jsp" role="button">GO</a></p>
    </div>
    
    <div class="col-md-4"> <img class="img-circle" src="images/b9.png" alt="">
      <h2>失物招领</h2>
      <p><a class="btn btn-warning btn-lg col-sm-offset-4 col-md-4" href="${pageContext.request.contextPath }/thingking/announce.jsp" role="button">GO</a></p>
    </div>
    
    
    
    
    
    
    
    <div class="col-md-4"> <img class="img-circle" src="images/b4.jpg" alt="">
      <h2>易帮帮(待开发...)</h2>
      <p><a class="btn btn-primary btn-lg col-sm-offset-4 col-md-4" href="#" role="button">GO</a></p>
    </div>
    
     <div class="col-md-4"> <img class="img-circle" src="images/b8.png" alt="">
      <h2>社区兴趣(待开发...)</h2>
      <p><a class="btn btn-info btn-lg col-sm-offset-4 col-md-4" href="#" role="button">GO</a></p>
    </div>
 
 
 
    <div class="col-md-4"> <img class="img-circle " src="images/b1.jpg" alt="">
      <h2>易置物(待开发...)</h2>
      <p><a class="btn btn btn-danger btn-lg col-sm-offset-4 col-md-4" href="#" role="button" >GO</a></p>
    </div>
   
   
   
   
    <div class="col-md-4"> <img class="img-circle" src="images/b5.jpg" alt="">
      <h2>未完待续...</h2>
      <p><a class="btn btn-success btn-lg col-sm-offset-4 col-md-4" href="#" role="button">GO</a></p>
    </div>
   
  </div>
  <!--分界线-->
  <hr class="feature-divider">
  <h1 class="wow fadeInDown" >每日精品:</h1>
  </br>
  <!--导航条-->
 <c:forEach items="${rdlist}" var="pd" varStatus="status"> 
  <div class="tab-content">
    <div class="tab-pane active wow slideInLeft" id="tab-book">
      <div class="row feature">
        <div class="col-md-7">
          <h2 class="feature-heading">${pd.getPname()}</h2>
          <p class="lead"><font color="#FF2D2D">¥：${pd.getPrice()}</font></p>
        </div>
        <div class="col-md-5"> <a href=""><img class="feature-image img-rounded" src="upload_images/${pd.getPicture()}" alt="1"></a> </div>
      </div>
    </div>
   
   
    
  </div>
  </c:forEach>
  <hr class="feature-divider">
</div>
<div class="container-fluid">
<div class="row">
  <footer> 
    <!--pull-right 浮动到右边-->
    <p class="pull-right"><a href="#top">回到顶部</a></p>
    <p class="col-sm-offset-6" center>@2018 </p>
  </footer>
</div>

<!--关于模态框-->
<div class="modal fade" id="about" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">校园二手交易系统</h4>
      </div>
      <div class="modal-body">
        <p>易班  工院易生活</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">了解</button>
      </div>
    </div>
  </div>
</div>


<script>
$(function(){

new WOW().init();
})
</script>
</body>
</html>
    