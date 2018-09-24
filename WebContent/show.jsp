<%@page import="com.beans.Book.Book"%>
<%@page import="java.util.List"%>
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
List<Book>list=(List<Book>)request.getAttribute("books");
%>
<table border=120>
<tr>
    
	<td><%out.println("Book"); %></td>
	<td><%out.println("Author"); %></td>
	<td><%out.println("ISBN"); %></td>
	<td><%out.println("Price"); %></td>
	<td><%out.println("Publication"); %></td>
</tr>
<%
for(Book b:list)
{
%>	
<tr>
    
	<td><%=b.getBookName()%></td>
	<td><%=b.getAuthor() %></td>
	<td><%=b.getISBN()%></td>
	<td><%=b.getBookPublication()%></td>
	<td><%=b.getPrice()%></td>
</tr>
<% 

}
%>

</table>
</body>
</html>