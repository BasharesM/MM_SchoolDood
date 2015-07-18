<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>

<%@ page import="entities.User" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School Dood</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/materialize.min.css"
	type="text/css" media="screen, projection" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

	<nav class="blue lighten-3">
		<div class="container">
			<div class="nav-wrapper">
				<a href="${pageContext.request.contextPath}/home" class="brand-logo">School Dood</a>
				<% User user = (User) request.getSession().getAttribute("user"); %>
				<% if (user != null) { %>
				
				<ul class="right hide-on-med-and-down">
					<li><a href="/MM_SchoolDood/Email">Liste des emails</a></li>
					<li><a href="/MM_SchoolDood/logout"><%= user.getFirst_name() %><i class="material-icons right">power_settings_new</i></a></li>
				</ul>
				<% } %>
			</div>
		</div>
	</nav>

	<div class="container" style="padding-top: 20px;">
	
	<c_rt:if test="${requestScope.messageFlash}">
		<div class="row">
	      <div class="col s12 m5">
	        <div class="card-panel teal">
	          <span class="white-text">
	          
	            <%
					if (request.getAttribute("message") == "logout") {
				%>
					Déconnexion réussie.
				<%
					}
				%>
				
				<%
					if (request.getAttribute("message") == "loginError") {
				%>
					Identifiants incorrects.
				<%
					}
				%>
	          	
	          </span>
	        </div>
	      </div>
	    </div>
    </c_rt:if>    