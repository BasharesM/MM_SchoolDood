<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ page import="entities.CategoryAnswers" %>
<%@ page import="entities.CategoryAnswer" %>
<%@ page import="entities.Emails" %>
<%@ page import="entities.Email" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>School Dood ! Merci de vous identifier</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css" type="text/css" media="screen, projection" />
	</head>
<body>

<% CategoryAnswers categories = (CategoryAnswers) request.getAttribute("categories"); %>
<% Emails emails = (Emails) request.getAttribute("emails"); %>

<div class="row">
	<div class="card blue lighten-5 col m4 offset-m4">
		<form method="post" action="/MM_SchoolDood/login">
			<div class="input-field col m12">
				<label for="question">Question</label>
				<input type="text" id="question" name="question"/>
			</div>
			<div class="col m12">
				<label for="caid">Type de réponse</label>	
				<select class="browser-default" id="caid" name="caid">
					<% for(int i = 0 ; i < categories.size() ; i++) { 
						 CategoryAnswer category = (CategoryAnswer) categories.get(i); 
					%>
						<option value="<% out.print(category.getCaid()); %>"> <% out.print(category.getLabel()); %></option>
					<% } %>
				</select>			
			</div>
			<div class="input-field col m12">
				<p>
		      	<input type="checkbox" name="status" id="status" />
		      	<label for="status">Privé</label>
		    	</p>
	    	</div>
	    	
	    	<div class="row input-field"></div>
	    	
		    <div id="wrapper-datetime">
		    	<div class="row" id="content-datetime">
					<div class="datetime">
						<div class="col m6">
							<div class="col m12">
								<span>Horaire <span class="number">1</span></span><br/>
								<label for="date">Date : </label><br/>
								<input type="date" id="date" class="datepicker" name="datetime[date][]"/>
							</div>
		    				<div class="col m6">
		    					<label>Heure : </label>
		    					<input type="time" id="hour" name="datetime[hour][]"/>
		    				</div>
		    				<div class="col m6">
		    					<label>Minute : </label>
		    					<input type="time" id="min" name="datetime[min][]"/>
		    				</div>
		    			</div>
		    		</div>      
		    	</div>
		    	
				<a id="poire" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
			</div>
			
			<div class="row input-field"></div>
	    	
			<div class="row">
				<div class="col m12">
					<label>Personne à contacter</label>
				</div>
				
				<% for (int j = 0 ; j < emails.size() ; j++) { %>
					<% Email email = emails.get(j); %>
					<div class="col m6 input-field c">
						<p>
							<input type="checkbox" name="emails[]" id="email-<%= email.getEid() %>" value="<%= email.getEid() %>"/>
							<label for="email-<%= email.getEid() %>"><%= email.getEmail() %></label>
						</p>
					</div>
				<% } %>
			</div>
			<button type="submit" class="btn waves-effect waves-light" value="S'inscrire">
				Créer<i class="material-icons"></i>
			</button>
		</form>
	</div>
</div>

<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/materialize.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/customize.js"></script>
</body>
</html>