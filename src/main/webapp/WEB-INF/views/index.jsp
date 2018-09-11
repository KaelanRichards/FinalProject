 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Spot DangerHood</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />

</head>

<body>

 ${login}
<h1>Login Page</h1>

<form action = "/display" method = "post">


<div class="tab">User Name:
  <p><input id = "username" type = "text" name = "username" required ></p>
 
</div>

<label>Password:
  <p><input name="password" id="password" type="password" onclick ='check();' /><span id='message'></span></p>
</label>
<br>
<label>Confirm password:
  <p><input type="password" name="confirmPassword" id="confirmPassword"  onclick='check();'/>   </p>

  </label> <br>


<input type="checkbox" onclick='showPassword()' onchange = 'check_pass();'/>Show Password

<input type = "submit" value = "Login">
</form>


<script src = "js/script.js"></script>


</body>
</html>