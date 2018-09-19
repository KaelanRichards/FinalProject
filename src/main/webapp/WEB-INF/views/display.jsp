<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
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
  </div>
</nav>
<div class="container">
${login}

<br>
<h3>Please fill the form to register!</h3>
<br>
<form name ="regForm" action="/User" method="post">

<!-- One "tab" for each step in the form: -->
<div class="form-group">First Name:
<!--  <input type = "text" name = "firstName">-->
  <p><input id = "firstName" type = "text" name = "firstname" placeholder = "First Name"></p>
 
</div>


<div class="form-group">Last Name:
 <p><input id = "lastName" type = "text" name = "lastname" placeholder = "Last Name" ></p>
</div>


<div class="form-group">User Name:
  <p><input id = "userName" type = "text" name = "username" placeholder = "User Name" required ></p>
  </div>
  
  <div class="form-group">Phone:
  <p><input id = "phone" type = "text" name = "phone" placeholder="123-456-7890"
            required/></p>
</div>

<div class="form-group">Password:
 <p> <input name="password" id="password" type="password" placeholder = "Password"  /></p>
</div>

<div class="form-group">Confirm password:
  <p><input type="password" name="confirmpassword" id="confirmPassword" placeholder = "Retype Password" /></p>
  </div>


<input class="btn btn-primary" type = "submit" value = "Register">
</form>
</div>
</body>
</html>