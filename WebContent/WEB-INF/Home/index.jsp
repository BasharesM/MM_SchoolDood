<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/MM_SchoolDood/static/css/material.min.css">
</head>
<body>

<div class="mdl-card mdl-shadow--2dp demo-card-wide">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Welcome</h2>
  </div>
  <div class="mdl-card__supporting-text">
    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
    Mauris sagittis pellentesque lacus eleifend lacinia...
  </div>
  <div class="mdl-card__actions mdl-card--border">
    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
      Get Started
    </a>
  </div>
  <div class="mdl-card__menu">
	<form method="post" action="/MM_SchoolDood/login">
		<label for="username">Pseudo : </label>
		<input type="text" name="username"/>
		<label for="password">Password : </label>
		<input type="text" name="password"/>
		<input type="submit" value="S'inscrire"/>
	</form>

    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>
</div>


<script src="/MM_SchoolDood/static/js/material.min.js"></script>
</body>
</html>