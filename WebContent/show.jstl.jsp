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
<table border=5>
<tr>
<td><c:out value="ISBN"></c:out></td>
<td><c:out value="NAME"></c:out></td>
<td><c:out value="PUBLICATION"></c:out></td>
<td><c:out value="AUTHOR"></c:out></td>
<td><c:out value="PRICE"></c:out></td>
</tr>
<c:forEach var="book" items="${books}">
<tr>
<td><c:out value="${book.ISBN}"></c:out></td>
<td><c:out value="${book.bookName}"></c:out></td>
<td><c:out value="${book.bookPublication}"></c:out></td>
<td><c:out value="${book.author}"></c:out></td>
<td><c:out value="${book.price}"></c:out></td>
<td><a href="delete?isbn=<c:out value='${book.ISBN}'/>">DELETE</a></td>

</tr>
</c:forEach>

</table>
</body>
</html>