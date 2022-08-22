<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="productdt" value="${obj }"></c:set>
Id: ${productdt.id } <br>
Name: ${productdt.name } <br>
Price: ${productdt.price } <br>
<br>
</body>
</html>