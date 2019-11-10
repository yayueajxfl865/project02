<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style type="text/css">

#pilter{
font-family: "微软雅黑";
font-size: 20px;
color: #999;
}


</style>


<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath }/js/upload.js"></script>
<body>
<div id="pilter">&nbsp;&nbsp;&nbsp;&nbsp;图片</div>
<br>

<div id="drop_area"></div>


</body>
<script type="text/javascript">
    var dragImgUpload = new DragImgUpload("#drop_area",{
        callback:function (files) {
            //回调函数，可以传递给后台等等
            var file = files[0];
            console.log(file.name);
        }
    })
</script>
</html>