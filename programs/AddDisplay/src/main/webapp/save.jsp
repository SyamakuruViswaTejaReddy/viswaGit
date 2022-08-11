<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="${param.pname}"></c:set>
<c:set var="desc" value="${param.pdesc}"></c:set>
<c:set var="quantity" value="${param.pquantity}"></c:set>
<c:set var="price" value="${param.pprice }"></c:set>
Product Name:<c:out value="${name}"></c:out>
<br></br>
Product Description:<c:out value="${desc}"></c:out>
<br></br>
Product Quantity:<c:out value="${quantity}"></c:out>
<br></br>
Product Price:<c:out value="${price}"></c:out>
</body>
</html>