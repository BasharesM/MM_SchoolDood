<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="entities.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>School DoodZ</title>
	</head>
<body>

<% User user = (User) request.getSession().getAttribute("user"); %>
<%= user.getFirst_name() %>

<a href="/MM_SchoolDood/logout">Déconnexion</a>
</body>
</html>