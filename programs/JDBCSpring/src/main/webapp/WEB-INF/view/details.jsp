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
<h3>Products Details Page</h3>
<c:set var="product" value="${obj }"></c:set>
Id: ${product.id } <br>
Name: ${product.name } <br>
Price: ${product.price } <br>
Date: ${product.dateAdded } <br>
<br>
<form action="update" method="get">
<input type="Number" name="id" value="${product.id}"><br>
Enter updated name:<input type="text" name="name"><br>
Enter updated price:<input type="Number" name="price"><br>
 <input type="submit" value="Get By Id">
  </form>

</body>
</html>