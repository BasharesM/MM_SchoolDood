<%@ page import="entities.AnswerResults" %>
<%@ page import="entities.AnswerResult" %>

<%
	AnswerResults answerResults = (AnswerResults) request.getAttribute("answers");
%>

<% if (answerResults.size() == 0) { %>
        
        Aucune stats à afficher
        
<% } else { %>
	<% for(int i=0; i < answerResults.size(); i++) { %>
		<div class="row">
			<div class="col m6">
				<div class="collection">
		        	<% AnswerResult answerResult = (AnswerResult) answerResults.get(i); %>
					<canvas class="myChart" data-date="<%= answerResult.getDate() %>" data-heure="<%= answerResult.getHeure() %>" data-count="<%= answerResult.getCount() %>" data-label="<%= answerResult.getLabel() %>" width="400" height="400"></canvas>
				</div>
			</div>
		</div>
	<% }
}%>