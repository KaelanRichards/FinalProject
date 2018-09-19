 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Crime-Spy (Detroit edition)</title> 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cerulean/bootstrap.min.css" />

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="/" >DETROIT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>



  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/index">Log In <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/display">Register</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="/resources">Resources</a>
      </li>
      <li class="nav-item">
      <!-- need to redirect to search page after invalidating the http session
      request mapping to logout controller method and then use redirect for the modelandview jsp page? -->
      	<a class="nav-link" href="/logout">Log Out</a>
      </li>
    </ul>
     <img align = "right" src = "images/test1.jpg" width="40" height="40">
  </div>
</nav>
<br>
<div class="container">
 ${login}
<h1>Login Page</h1>
<br>
<form action = "/login" method = "post">


<div class="tab">User Name:
  <p><input id = "username" type = "text" name = "username" required ></p>
 
</div>

<label>Password:
  <p><input name="password" id="password" type="password" oninput ='check();' /><span id='message'></span></p>
</label>
<br>
<label>Confirm password:
  <p><input type="password" name="confirmPassword" id="confirmPassword"  oninput='check();'/>   </p>

  </label> <br>


<input type="checkbox" onclick='showPassword()' onchange = 'check_pass();'/>Show Password

<input class="btn btn-primary" type = "submit" value = "Login">
</form>
<br>

<a href= "/display"><button class="btn btn-primary">New? Register here...</button></a>
</div>
	<script src="js/script.js"></script>


</body>
</html>