<%@ page import="entities.AnswerResults" %>
<%@ page import="entities.AnswerResult" %>

<%
	AnswerResults answerResults = (AnswerResults) request.getAttribute("answers");
%>

<% if (answerResults.size() == 0) { %>
        
        Aucune stats à afficher
        
<% } else { %>
<script>
	var values = [];
	var dates = [];

	<% for(int i=0; i < answerResults.size(); i++) {
		AnswerResult answerResult = (AnswerResult) answerResults.get(i); %>
		if(values["<%= answerResult.getDate() %> - <%= answerResult.getHeure() %>"] == undefined){
			values["<%= answerResult.getDate() %> - <%= answerResult.getHeure() %>"] = [];
			dates.push("<%= answerResult.getDate() %> - <%= answerResult.getHeure() %>");
		}
		values["<%= answerResult.getDate() %> - <%= answerResult.getHeure() %>"].push({label: "<%= answerResult.getLabel() %>", count: "<%= answerResult.getCount() %>"});
		
	<% } %>
	var answers = values;
	</script>
<%}%>



		
				<div class="charts row">
				</div>

