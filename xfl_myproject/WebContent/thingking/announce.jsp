
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.util.List" %>
     <%@page import="com.myproject.entity.Goods" %>
      <%@page import="com.myproject.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>失物招领</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<%
GoodsService goodsService=new GoodsService();
List<Goods> gsList=goodsService.getAllGoods();
request.setAttribute("gsList", gsList);

%>


<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-info text-ight">
				失物招领
			</h3>
			<ul class="nav nav-pills">
				<li class="active">
					 <a href="#">首页</a>
				</li>
				<li>
					 <a href="${pageContext.request.contextPath}/GoodsServlet?method=enquire&kind=n">寻物启示</a>
				</li>
				<li>
					 <a href="${pageContext.request.contextPath}/GoodsServlet?method=enquire&kind=y">失物招领</a>
				</li>
				
				
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li> 
						     <c:if test="${myuser==null }">
							 <a href="${pageContext.request.contextPath }/LoginServlet?entry=entryaccout">登录</a>
						     </c:if>
						     <c:if test="${myuser!=null }">
							 <a href="${pageContext.request.contextPath }/LoginServlet?entry=existaccout">退出登录</a>
						     </c:if>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="${pageContext.request.contextPath }/thingking/releaseCount.jsp">招领发布</a>
						</li>
						
						<li class="divider">
						</li>
						<li>
						<a href="${pageContext.request.contextPath }/thingking/lostfabu.jsp">失物发布</a>
						</li>
						
						<li class="divider">
						</li>
						
						<li>
							 <a href="${pageContext.request.contextPath }/GoodsServlet?method=wpbyUser">发布信息</a>
						</li>

					</ul>
				</li>
			</ul>
			
			<!-- 滚动条部分 -->
			<div class="carousel slide" id="carousel-316516">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-316516">
					</li>
					<li data-slide-to="1" data-target="#carousel-316516">
					</li>
					<li data-slide-to="2" data-target="#carousel-316516">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="${pageContext.request.contextPath }/image/af.jpg" />
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="item">
						<img alt="" src="${pageContext.request.contextPath }/image/b.jpg" />
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="item">
						<img alt="" src="${pageContext.request.contextPath }/image/c.jpg" />
						<div class="carousel-caption">
							
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-316516" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-316516" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			
			
			<!-- 事务模块 -->
			<div class="row">
			<c:forEach items="${gsList }" var="at"> 
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
                                       <c:if test="${at.kind=='y' }">
                                       <td width="70" height="30" align="left" valign="middle">拾到地点：</td></c:if>
                                       <c:if test="${at.kind=='n' }">
                                       <td width="70" height="30" align="left" valign="middle">丢失地点：</td></c:if>
                                       
                                       <td width="270" height="30" align="left" valign="middle">${at.place }</td>
                                </tr>
                                <tr>
                                        <c:if test="${at.kind=='y' }">
                                        <td width="70" height="30" align="left" valign="middle">拾到时间：</td></c:if>
                                        <c:if test="${at.kind=='n' }">
                                        <td width="70" height="30" align="left" valign="middle">丢失时间：</td></c:if>
                                        
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
		</div>
	</div>
</div>
</body>
</html>