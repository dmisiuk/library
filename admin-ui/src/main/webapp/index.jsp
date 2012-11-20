<%@page import="by.minsler.library.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
User user = (User) request.getSession().getAttribute("user");
if (user != null) {
	response.sendRedirect("book");
} else {

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="cheet">
for test using: <br>login: <b>test</b> <br>password: <b>test</b>
</div>
<form id="login-form" action="login" method="post" >
	<input type="hidden" name="operation" value="login">
	<div>Login<br><input type="text" name="login"></div>
	<div>Password:<br><input type="password" name="password"> </div>
	<input type="submit" name="login-button" value="login">	
</form>


</body>
</html>

<%
}
%>