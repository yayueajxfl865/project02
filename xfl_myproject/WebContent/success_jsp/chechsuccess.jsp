<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
#a{
    position:absolute;
	left:28%;
	top:42%;

}

#b{
position:absolute;
	left:37%;
	top:45%;
	color: #F90;
	
	font-size: 50px
	

}
</style>



<table width="100" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td><div id="a">
<img alt="" src="../image/tmg.png" height="100" width="100">

</div></td>
    <td><div id="b"><a href="${pageContext.request.contextPath }/shop.jsp">购买成功！</a></div></td>
  </tr>
</table>

</body>
</html>