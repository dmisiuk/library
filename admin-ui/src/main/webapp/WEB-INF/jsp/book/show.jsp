<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="by.minsler.library.bean.Book"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>Show all book</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/book/template/logout.jsp"></jsp:include>
<h1>book list:</h1>
<br>
<a href="book?operation=add">Add new book</a>
<br>
<br>

<table  border="1">
<thead>
	<tr>
	<td>Name</td>
	<td>Author</td>
	<td>Description</td>
	<td>Date</td>
	<td>Price</td>
	<td>email-publisher</td>
	<td>Operation</td>
	</tr>
</thead>
<%
List<Book> list = (List<Book> ) request.getAttribute("list");
Iterator<Book> it  = list.iterator();
while(it.hasNext()){
	Book book = (Book) it.next();
%>
	
	<tr>
	<td><%= book.getName() %></td>
	<td><%= book.getAuthor() %></td>
	<td><%= book.getDescription() %></td>
	<td><%= book.getDate() %></td>
	<td><%= book.getPrice()%></td>
	<td><%= book.getUser().getEmail() %></td>
	<td>
	<a href="book?operation=edit&id=<%=book.getId()%>">Edit</a>
	<a href="book?operation=delete&id=<%=book.getId()%>">Delete</a>
	</td>
	</tr>
	
<%
}
%>
</table>
</body>
</html>