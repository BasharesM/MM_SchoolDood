<%@ page import="entities.Emails" %>
<%@ page import="entities.Email" %>

<%
	Emails emails = (Emails) request.getAttribute("emails");
%>

<div class="row">
	<div class="col m6">
	
        <% if (emails.size() == 0) { %>
        
        Aucun email à afficher
        
        <% } else { %>
        <div class="collection">
        	<% for(int i=0; i < emails.size(); i++) {
        
        	Email email = (Email) emails.get(i); %>
			<a href="#!" class="collection-item"><%= email.getEmail() %></a>
		<% } %>
		</div>
		<%
        	}%>
		
	</div>
	<div class="col m6">
		<form id="addEmailForm" method="POST" action="/MM_SchoolDood/Email">
			<label for="email">Email : </label>
			<input type="email" name="email" />
			<button type="submit" class="waves-effect waves-light btn">Ajouter</button>
		</form>
	</div>
</div>