<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
	
		<script type="text/javascript" src="${pageContext.request.contextPath }js/jquery.js" ></script>
		<script type="text/javascript" src="js/boostrap.js" ></script>
		<title></title>
		<script type="text/javascript">
		$(function(){
		
			$(".nav").click(function(){
				
				$("#form1").submit();
			});
			
			
		})
		
		</script>
		
	</head>
<style>
	.nav {
    background:#0CC;
   
    width: 100%;
    position: fixed;
    left: 0;
    bottom: 0;
    height: 40px;
    line-height: 40px;
    text-align: center;
    font-family: "微软雅黑";
    font-size: 20px;
}
</style>
	<body>
		<div class="nav" style="color: white;">
           发布
        </div>

	</body>
</html>
    