<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/MM_SchoolDood/static/css/material.min.css">
</head>
<body>


	<form method="post" action="/MM_SchoolDood/login">
		<label for="username">Pseudo : </label>
		<input type="text" name="username"/>
		<label for="password">Password : </label>
		<input type="text" name="password"/>
		<input type="submit" value="S'inscrire"/>
	</form>



<c_rt:if test="${requestScope.logout}">
	Déconnexion réussie s.
</c_rt:if>

<% if(request.getAttribute("logout") != null) { %>
	Déconnexion réussie.
<% } %>


<script src="/MM_SchoolDood/static/js/material.min.js"></script>
</body>
</html>