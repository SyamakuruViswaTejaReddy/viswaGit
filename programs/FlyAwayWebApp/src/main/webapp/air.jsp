<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#87CEFA;">
<h1 style="background-color:#000000;color:#E6E6FA">Search for Flights!!!</h1>
<form action="airlines"  method="post">
<b>Name:</b><input type="text" name="uname">
<br>
<br>
<label for="from"><b>From:</b>
</label>
<select name="from" id="from">
 <option value="Hyderabad">Hyderabad</option>
 <option value="Mumbai">Mumbai</option>
 <option value="Bangalore">Bangalore</option>
</select>
<br>
<br>
<label for="to"><b>To:</b>
</label>
<select name="to" id="to">
 <option value="Hyderabad">Hyderabad</option>
 <option value="Mumbai">Mumbai</option>
 <option value="Bangalore">Bangalore</option>
</select>
<br>
<br>
<b>Travel Date:</b><input type="Date" name="TD">
<br>
<br>
<b>No_Of_Travellers:</b><input type="Number" name="NOT">
<br>
<br>
<input type="submit" value="Show Flights">
</form>
</body>
</html>