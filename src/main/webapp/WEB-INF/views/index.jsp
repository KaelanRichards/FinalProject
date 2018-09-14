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
<nav class="navbar navbar-expand-lg navbar-dark bg-primary" >
  <a class="navbar-brand" href="/search" >DETROIT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Log In <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/display">Register</a>
      </li>
    </ul>
  </div>
</nav>
 ${login}
<h1>Login Page</h1>

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

<input type = "submit" value = "Login">
</form>
<br>

<a href= "/display"><button>New User? Register here..</button></a>

<script src = "js/script.js"></script>


</body>
</html>