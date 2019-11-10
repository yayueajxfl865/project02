<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="net.sf.json.*"%>
<%@page import="cn.yiban.util.HTTPSimple"%>
<%@page import="com.myproject.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取用户群信息页面</title>
</head>
<body>



	<table align="center" border="2" cellpadding="1" cellspacing="0"
		width="1200" height="500">
		<tr>

			<td height="50">group_id</td>
			<td>group_name</td>
			<td>group_icon</td>
			<td>group_type</td>
			<td>adm_uid</td>
			<td>adm_nick</td>
			<td>group_mamber</td>
		</tr>

		<tr>
			<td height="50">群ID</td>

			<td>群名称</td>
			<td>群图标</td>
			<td>群类型</td>
			<td>群创建者用户ID</td>
			<td>群创建者用户昵称</td>
			<td>群成员数</td>
		</tr>

		<tr>

			<td height="200">
				<%
					String method_id = request.getParameter("method");
					if (method_id.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("group_id") + "<br>");
							}
						}
					}
				%>



			</td>
			<td>
				<%
					String method_name = request.getParameter("method");
					if (method_name.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("group_name") + "<br>");
							}
						}
					}
				%>
			</td>
			<td>
				<%
					String method_icon = request.getParameter("method");
					if (method_icon.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("group_icon") + "<br>");
							}
						}
					}
				%>

			</td>
			<td>
				<%
					String method_type = request.getParameter("method");
					if (method_type.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("group_type") + "<br>");
							}
						}
					}
				%>


			</td>
			<td>
				<%
					String method_uid = request.getParameter("method");
					if (method_uid.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("adm_uid") + "<br>");
							}
						}
					}
				%>


			</td>
			<td>
				<%
					String method_nick = request.getParameter("method");
					if (method_nick.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("adm_nick") + "<br>");
							}
						}
					}
				%>



			</td>
			<td>
				<%
					String method_mamber = request.getParameter("method");
					if (method_mamber.equals("group_public_group")) {
						String query = APIUtil.PUBLIC_GROUP + "?access_token="
								+ request.getSession().getAttribute("access_token");
						JSONObject backJson = JSONObject.fromObject(HTTPSimple.GET(query));
						JSONArray jsonArray = backJson.getJSONObject("info").getJSONArray("public_group");
						if (jsonArray.size() > 0) {
							for (int i = 0; i < jsonArray.size(); i++) {
								JSONObject job = jsonArray.getJSONObject(i);
								out.print(job.get("group_mamber") + "<br>");
							}
						}
					}
				%>

			</td>

		</tr>

	</table>

</body>
</html>