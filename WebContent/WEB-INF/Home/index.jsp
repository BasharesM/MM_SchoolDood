<div class="row">
	<div class="col s12 m6">
		<div class="card blue lighten-5">
		<form method="post" action="/MM_SchoolDood/login">
			<div class="card-content black-text">
				<span class="card-title black-text" style="margin-bottom: 10px;">Inscription</span>
				<div style="margin-top: 10px;">
					<label for="first_name">Prénom : </label>
					<input type="text" name="first_name" />
					<label for="last_name">Nom : </label>
					<input type="text" name="last_name" />
					<label for="email">Email : </label>
					<input type="email" name="email" />
					<label for="password">Password : </label>
					<input type="password" name="password" />
				</div>
			</div>
			<div class="card-action right-align">
				<input type="submit" class="waves-effect waves-light btn" value="S'inscrire" />
			</div>
			</form>
		</div>
	</div>

	<div class="col s12 m6">
		<div class="card blue lighten-5">
		<form method="post" action="/MM_SchoolDood/login">
			<div class="card-content black-text">
				<span class="card-title black-text">Connexion</span>
				<div style="margin-top: 10px;">
				
					<label for="username">Prénom : </label>
					<input type="text" name="username" />
					<label for="password">Password : </label>
					<input type="password" name="password" />
				
				</div>
			</div>
			<div class="card-action right-align">
			<input type="submit" class="waves-effect waves-light btn" value="Se connecter" />
			</div>
			</form>
		</div>

	</div>
</div>

<!--
<c_rt:if test="${requestScope.logout}">
	Déconnexion réussie s.
</c_rt:if>
-->

<%
	if (request.getAttribute("logout") != null) {
%>
Déconnexion réussie.
<%
	}
%>