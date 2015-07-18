<div class="row">
	<div class="col s12 m6">
		<div class="card blue lighten-5">
		<form id="signupForm" method="post" action="/MM_SchoolDood/user/register">
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
				<a href="#" id="signup" class="waves-effect waves-light btn">S'inscrire</a>
			</div>
			</form>
		</div>
	</div>

	<div class="col s12 m6">
		<div class="card blue lighten-5">
		<form id="loginForm" method="post" action="/MM_SchoolDood/login">
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
			<a href="#" id="login" class="waves-effect waves-light btn">Se connecter</a>
			</div>
			</form>
		</div>

	</div>
</div>