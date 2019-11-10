<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    //添加图片
    $("div .subMenu>img").each(function() {
        var name = $(this).attr("data-imgname");
        var src = "http://www.jq22.com/img/cs/500x300-" + name + ".png"
        //设置img的属性和值。
        $(this).attr("src", src);
    });

    //点击事件
    $("div .subMenu").click(function() {
        // 取消当前激活状态
        var $img = $(".active>img");
        //返回被选元素的属性值
        var name = $img.attr("data-imgname");
        var src = "http://www.jq22.com/img/cs/500x300-" + name + ".png";
        $img.attr("src", src);
        $(".active").removeClass("active");

        // 添加新状态
        $(this).addClass("active");
        //找到所有 div(subMenu) 的子元素(img)
        $img = $(this).children("img");
        name = $img.attr("data-imgname");
        src = "http://www.jq22.com/img/cs/500x300-" + name + ".png";
        //设置img的属性和值。
        $img.attr("src", src);

        //content根据点击按钮加载不同的html
        var page = $(this).attr("data-src");
        if (page) {
            $("#content").load("../html/" + page)
        }
    });

    // 自动点击第一个菜单
    $("div .subMenu")[0].click();
});

/*content高度*/
function initSize() {
    var height = $(window).height() - $("header").height() - $("#description").height() - $("#menu").height();
    $("#content").height(height + "px");
}



</script>

</head>
<style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 微软雅黑;
        }

        header {
            height: 40px;
           
            width: 100%;
            color: #fff;
            font-family: "黑体";
            font-weight: 100;
            font-size: 15px;
            /*背景色渐变*/
            background: linear-gradient(to bottom right, #F56739, #FB9749);
        }

        #content {
            background: linear-gradient(to bottom right, #f5f454, #fbd1b7);
        }

        .menu {
            display: block;
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 70px;
            color: #474747;
            padding-top: 10px;
            border-top: 1px solid #eee;
            background-color: #46B8DA;
        }

        .subMenu {
            width: 20%;
            float: left;
            cursor: pointer;
        }

        .menu_name {
            height: 30px;
            width: 100%;
            line-height: 40px;
            font-size: 13px;
        }

        img.menu_img {
            height: 24px;
            width: 24px;
           
        }

        img {
            vertical-align: middle;
            border: 0;
        }

        .active {
            color: #FFA129;
        }

        .text-center {
            text-align: center
        }



</style>


<body>
    <header>
    <%@ include file="top.jsp" %>
    </header>
    
   
    
    <div id="content">
   
    
  <jsp:include page="content.jsp"></jsp:include>
    
    
    </div>
    
    <div id="menu" class="menu">
        <div id="one" class="subMenu text-center" data-src="">
           <img class="menu_img" data-imgname="1" src="${pageContext.request.contextPath }/views/forum/images/home.ico"></a>
            <div class="menu_name">首页</div>
        </div>
        <div id="two" class="subMenu text-center">
            <img class="menu_img" data-imgname="2" src="${pageContext.request.contextPath }/views/forum/images/heart.ico">
            <div class="menu_name">关注</div>
        </div>
        <div id="three" class="subMenu text-center" data-src="personal.html">
            <a href="relea_frame.jsp"><img class="menu_img" data-imgname="3" src="${pageContext.request.contextPath }/views/forum/images/fabu.ico"></a>
            <div class="menu_name">发布</div>
        </div>
        <div id="four" class="subMenu text-center" data-src="personal.jsp">
            <a href="personal.jsp"><img class="menu_img" data-imgname="4" src="${pageContext.request.contextPath }/views/forum/images/geren.ico"></a>
            <div class="menu_name">个人</div>
        </div>
        <div id="five" class="subMenu text-center" data-src="personal.html">
            <img class="menu_img" data-imgname="5" src="${pageContext.request.contextPath }/WEB-INF/views/forum/images/edit.icos">
            <div class="menu_name">退出</div>
        </div>
    </div>

</body>
</html>