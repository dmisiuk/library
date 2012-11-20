<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%--<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>--%>
<%@page import="by.minsler.library.bean.Book"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add book</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/book/template/logout.jsp"></jsp:include>
<h1>Add new Book</h1>


<form action="book" >
	<input type="hidden" name="operation" value="addWrite">
	<table>
	<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
	<tr><td>Author:</td><td><input type="text" name="author"></td></tr>
	<tr><td>Description:</td><td><textarea name="description" rows="3" cols="100"></textarea></td></tr>
	<tr><td>Date:</td><td><input type="text" name="date"></td></tr>
	<tr><td>Price:</td><td><input type="text" name="price"></td></tr>
	</table>
    date format: 2012-02-02
	<br><input type="submit" name="add" value="add">
</form>

</body>
</html>