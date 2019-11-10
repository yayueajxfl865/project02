<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/boostrap.js" ></script>
		<title></title>
	</head>
	<style>
	
	
		.nav {
    background: #009c39;
    padding: 10px 0 6px 0;
    width: 100%;
    position: fixed;
    left: 0;
    bottom: 0;
    
    
}
.nav ul {
    height: 0px;
}
.nav ul li {
    float: left;
    width: 25%;
    text-align: center;
    list-style-type: none;
    margin: 0px;
    padding: 0px;
}
.nav ul li span {
    display: block;
    color: #fff;
    font-size: 14px;
    font-family: "微软雅黑";
    line-height: 22px;
}
a {
    color: #000;
    text-decoration: none;
}
* {
    padding: 0;
    margin: 0;
    list-style: none;
    font-weight: normal;
}

	</style>
	<body>
		<div class="nav">
            <ul>
                <li>
                    <a href="#"><span><img  src="${pageContext.request.contextPath }/views/forum/img/chongzhiqia.png" height="20"></span><span>首页</span></a>
                </li>
                <li style="position:relative;">
                    <a href="#"><span><img src="img/goumaijilu.png" height="20"></span><span>购买记录</span></a>
                </li>
                <li>
                    <a href="#"><span><img src="img/gouwuche1 (1).png" height="20"></span><span>我的篮子</span></a>
                </li>
                <li>
                    <a href="#"><span><img src="img/gerenzhongxinsvg (1).png" height="20"></span><span>个人中心</span></a>
                </li>
            </ul>
        </div>

	</body>
</html>
