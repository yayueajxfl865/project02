<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
					<a href="#">失物招领&nbsp;&nbsp;&gt;</a>
					
				</div>
             </div>
         </div>
<!-- 事务模块 -->
			<div class="row">
			<c:forEach items="${kindList }" var="at"> 
				<div class="col-md-4">
					<div class="thumbnail">
					<table width="320" height="220" border="0" cellspacing="1" cellpadding="1">
                        <tr>
                            <td align="center"><img align="middle" width="300" height="200" alt="300*200" src="${pageContext.request.contextPath }/account_images/${at.photo}" /></td>
                        </tr>
                      </table>
						
						<div class="caption">
							<h3>
								${at.gName }
							</h3>
							<p>
								<table width="340" height="100" border="0" cellspacing="1" cellpadding="1">
                               <tr>
                                       <td width="70" height="30" align="left" valign="middle">拾到地点：</td>
                                       <td width="270" height="30" align="left" valign="middle">${at.place }</td>
                                </tr>
                                <tr>
                                        <td width="70" height="30" align="left" valign="middle">拾到时间：</td>
                                        <td width="270" height="30" align="left" valign="middle">${at.gtime }</td>
                                 </tr>
                                 <tr>
                                         <td width="70" height="40" align="left" valign="middle">物品详情：</td>
                                         <td width="270" height="40" align="left" valign="middle">${at.describe }</td>
                                 </tr>
                                  </table>
							</p>
							<p>
								 <a class="btn btn-primary" href="${pageContext.request.contextPath }/GoodsServlet?method=getThewuping&wpid=${at.id}">认领</a> <a class="btn" href="#">详情</a>
							</p>
						</div>
					</div>
				</div>
	         </c:forEach>
			</div>
			<ul class="pagination">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>

</body>
</html>