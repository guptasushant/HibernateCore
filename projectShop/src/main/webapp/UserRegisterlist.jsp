<%@page import="com.pojo.Register"%>
<%@page import="java.util.List"%>
<%@page import="com.model.BlManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%
BlManager bl = new BlManager();
List<Register> reglist = bl.showUserList();
request.setAttribute("reglist", reglist);
%>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<table border="1" width="50%" style="text-align: center;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Phone</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="re" items="${reglist}">
			<tr>
				<td><c:out value="${re.rid }"></c:out></td>
				<td><c:out value="${re.name }"></c:out></td>
				<td><c:out value="${re.email }"></c:out></td>
				<td><c:out value="${re.password }"></c:out></td>
				<td><c:out value="${re.phone }"></c:out></td>
				<td>
					<form action="DeleteServlet" method="get">
						<!-- Redirect to DeleteServlet when delete button is clicked -->
						<input type="hidden" name="rid" value="${re.rid}" />
						<!-- Pass user ID to DeleteServlet -->
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
