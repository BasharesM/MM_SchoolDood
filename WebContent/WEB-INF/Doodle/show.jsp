<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entities.Doodle" %>
<%@ page import="entities.Answers" %>

<c:set scope="request" var="doodle" value="${doodle}" />
<c:set scope="request" var="answers" value="${answers}" />
<c:set scope="request" var="dates" value="${dates}" />

<h1><c:out value="${doodle['question']}" /></h1>

<form method="post" action="/MM_SchoolDood/reply">
	<div class="row">
		<div class="input-field">
			<input type="text" id="name" name="name"/>
			<label for="name">Votre nom : </label>
		</div>
	</div>
	
	<div class="row">
		<div class="col m6">
			<c:forEach var="i" begin="0" end="${dates.size()-1}">
				<c:set scope="request" var="date" value="${dates.get(i)}" />
				<p>
		      		<input name="daid" type="radio" value="<c:out value="${date.getDaid()}"/>" id="date-<c:out value="${date.getDaid()}"/>" />
		      		<label for="date-<c:out value="${date.getDaid()}"/>"><c:out value="${date.getDate()}"/></label>
		    	</p>
			</c:forEach>
		</div>
		<div class="col m6">
			<c:forEach var="i" begin="0" end="${answers.size()-1}">
				<c:set scope="request" var="answer" value="${answers.get(i)}" />
				<p>
		      		<input name="aid" type="radio" value="<c:out value="${answer.getAid()}"/>" id="answer-<c:out value="${answer.getAid()}"/>" />
		      		<label for="answer-<c:out value="${answer.getAid()}"/>"><c:out value="${answer.getLabel()}"/></label>
		    	</p>
			</c:forEach>
		</div>	
	</div>
		
	<input type="hidden" name="did" value="<c:out value="${doodle['did']}"/>"/>
	<input type="hidden" name="token" value="<c:out value="${doodle['token']}"/>"/>
	<button type="submit" class="btn">Donner votre réponse</button>
</form>