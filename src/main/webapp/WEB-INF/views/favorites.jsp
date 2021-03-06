<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Favorite Addresses to Track</title>
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
      	
		</ul>
		<a class="nav-link" href="/logout"align = "right">Log Out</a>
    <img align = "right" src = "images/test1.jpg" width="40" height="40">
  </div>
</nav>

${user.username}
	<table border = "1">
				<!-- this for each loop works just like an enhanced for loop in java -->
			<c:forEach var="f" items="${listFavs}">
			
					<tr>
						<td>${f.address}</td>
						<td>${f.category}</td>
						<td><a href="/edit/${f.favid}" >Edit</a></td>
						<td><a href="/delete/${f.favid}">Delete</a></td>
						
					</tr>
			</c:forEach>
	</table>


</body>
</html>