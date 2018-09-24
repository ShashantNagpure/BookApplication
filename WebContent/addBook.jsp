<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String message=(String)request.getAttribute("mymessage");
out.println(message+"<br>");
%>
<H2>Please fill up the form</H2>
<form action="addme" method="get">
BOOK NAME:<input type="text" name="bookname"><br>
ISBN:<input type="text" name="isbn"><br>
BOOK PRICE:<input type="text" name="bookprice"><br>
AUTHOR:<input type="text" name="author"><br>
PUBLICATION:<input type="text" name="publication"><br>
<input type="submit" value="ADD NEW BOOK">
</form>

</body>
</html>