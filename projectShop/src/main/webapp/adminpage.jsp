<%@page import="com.pojo.Register"%>
<%@page import="java.util.List"%>
<%@page import="com.model.BlManager"%>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%
BlManager bl = new BlManager();
List<Register> regL = bl.showUserList();
HttpSession sess = request.getSession();
sess.setAttribute("regL", regL);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('L.jpg');">
	<h2 style="text-align: center;">Welcome admin</h2>
	<h3>Registered users</h3>
	<form action="UserRegisterlist.jsp">
		<input type="submit" value="VIEW">
	</form>
	<br>
	<br>
	<h3>Add products</h3>
	<form action="AddProducts.jsp" method="post">
		<input type="submit" value="Insert">
	</form>
</body>
</html>