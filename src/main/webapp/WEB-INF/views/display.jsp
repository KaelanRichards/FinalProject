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
<nav class="navbar navbar-expand-lg navbar-dark bg-primary" >
  <a class="navbar-brand" href="/search" >DETROIT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Log In </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/display">Register<span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>

${login}


<h3>Please fill the form to register!</h3>

<form name ="regForm" action="/loginuser" method="post">

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


<input type = "submit" value = "Register">
</form>
<%-- <c:forEach var="a" items="${login }" >
	<tr>
	
	
	
	 <td>${a.username}</td> 
	 <td>${a.password}</td>
	 <td>${a.firstname}</td>
	 <td>${a.lastname}</td>
	 <td>${a.phone}</td>
	 <td>${a.confirmpassword}</td>
	 
	 <a href = "/add/${a.id}/${a.username}/${a.password}/${a.firstname}/${a.lastname}/${a.phone}/${a.confirmpassword}/"><button>Registerrrr</button></a>
	<!-- </tr> -->
	</c:forEach>


</form> --%>

</body>
</html>