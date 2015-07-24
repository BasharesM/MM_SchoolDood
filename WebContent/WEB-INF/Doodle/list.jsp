<%@ page import="entities.Doodles" %>
<%@ page import="entities.Doodle" %>

<%
	Doodles doodles = (Doodles) request.getAttribute("doodles");
%>

<div class="row">
	<div class="col m6">
	
        <% if (doodles.size() == 0) { %>
        
        Aucun doodle à afficher.
        
        <% } else { %>
        <div class="collection">
        	<% for(int i=0; i < doodles.size(); i++) {
        
        		Doodle doodle = (Doodle) doodles.get(i); %>
			<a href="/MM_SchoolDood/list-doodles?did=<%= doodle.getDid() %>" class="collection-item"><%= doodle.getQuestion() %></a>
		<% } %>
		</div>
		<%
        	}%>
		
	</div>
</div>