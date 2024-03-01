<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset style="height: 450px;width: 400px; margin: auto;">
<h3 style="text-align: center;">ADD NEW PRODUCT ENTRIES</h3>
<form action="AddProdServlet" method="post" style="text-align: center;">
Enter productId:<input type="text" name="productid"><br><br>
Enter product name:<input type="text" name="prodname"><br><br>
Enter price:<input type="text" name="price"><br><br>
Enter pay mode:<input type="text" name="paymode"><br><br>
Enter availability:<input type="text" name="availability"><br><br>
<input type="submit" name="ADD">
</form>
</fieldset> 
</body>
</html>