<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>School Dood ! Merci de vous identifier</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css" type="text/css" media="screen, projection" />
	</head>
<body>

<div class="row">
	<div class="col m4 offset-m4">
			<form method="post" action="/MM_SchoolDood/login">
			<label for="username">Pseudo : </label>
			<input type="text" name="username"/>
			<label for="password">Password : </label>
			<input type="text" name="password"/>
			<input type="submit" value="S'inscrire"/>
		</form>
	</div>
</div>



<c_rt:if test="${requestScope.logout}">
	Déconnexion réussie s.
</c_rt:if>

<% if(request.getAttribute("logout") != null) { %>
	Déconnexion réussie.
<% } %>


<script src="/MM_SchoolDood/static/js/jquery-2.1.4.min.js"></script>
<script src="/MM_SchoolDood/static/js/materialize.min.js"></script>
</body>
</html>