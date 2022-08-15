<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>welcome to airlines</h1></center>
<form action="airlines"  method="post">
Name:<input type="text" name="uname">
<label for="from">From:
</label>
<select name="from" id="from">
 <option value="Hyderabad">Hyderabad</option>
 <option value="Mumbai">Mumbai</option>
 <option value="Bangalore">Bangalore</option>
</select>
<br>
<br>
<label for="to">To:
</label>
<select name="to" id="to">
 <option value="Hyderabad">Hyderabad</option>
 <option value="Mumbai">Mumbai</option>
 <option value="Bangalore">Bangalore</option>
</select>
<br>
<br>
Travel Date:<input type="Date" name="TD">
<br>
No_Of_Travellers:<input type="Number" name="NOT">
<br>
<input type="submit" value="Show Flights">
</form>
</body>
</html>