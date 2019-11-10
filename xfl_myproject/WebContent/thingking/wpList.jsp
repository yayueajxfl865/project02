<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>


</head>
<body>
<div class="container">
            <div class="row">
               <div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/thingking/announce.jsp">首页&nbsp;&nbsp;&gt;</a>
					<a href="#">个人发布&nbsp;&nbsp;&gt;</a>
					
				</div>
             </div>
         </div>


<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							物品名称
						</th>
						<th>
						发布类型
						</th>
						<th>
							地点
						</th>
						<th>
							时间
						</th>
						<th>
							物品详情
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${goodsbyuser_list }" var="goodsuser">
					
					
					<tr class="info">
						<td>
							${goodsuser.getgName() }
						</td>
						<td>
						<c:if test="${goodsuser.kind=='y' }">失物招领</c:if>
						<c:if test="${goodsuser.kind=='n' }">寻物启示</c:if>
						
						</td>
						<td>
							${goodsuser.place }
						</td>
						<td>
							${goodsuser.gtime }
						</td>
						<td>
							${goodsuser.describe }
						</td>
						<td>
						<a href="${pageContext.request.contextPath }/GoodsServlet?method=deleteOnUser&deid=${goodsuser.getId() }">删除</a>						
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			

</body>
</html>