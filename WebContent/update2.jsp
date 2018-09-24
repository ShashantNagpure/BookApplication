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
<form action="listbook" method="post">
SELECT ISBN<select name="isbn">
<c:forEach var="book" items="${books}">
<option>${book.ISBN}</option>
</c:forEach>
</select><br>
<input type="submit" value="Submit">
</form>
</body>
</html>