<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ratings / Results</title>
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
${result} 



<h1>Your Crime Safety Rating Is </h1>
<h1>>>>${safetyString }<<<</h1>
<h6>__________________________________________________________________________</h6>
<h3>Crime Details</h3>
<p>Larceny:         ${larceny}</p>
<p>Stolen Vehicles: ${stolenVehicle}</p>
<p>Burglaries:      ${burglary}</p>
<p>Sexual Assaults: ${sexualAssault}</p>
<p>Robberies:       ${robbery}</p>
<p>Assaults:        ${assault}</p>
<p>Aggr. Assaults:  ${aggravatedAssault}</p>
<h6>__________________________________________________________________________</h6>
<h3>Police Department information</h3>
<h5>Your Closest Precinct: ${yourPrecinct}</h5>
<h5>Department:</h5> <p>${precinctInfo[0] }</p>
<h5>Address: </h5> <p>${precinctInfo[1] }</p>
<h5>Contact Information:</h5> <p>${precinctInfo[2] }</p>
<h6>__________________________________________________________________________</h6>
<h1>Project GreenLight Participants Near You</h1>

<table>
	<tr>
		<th>Business</th>
		<th>Address</th>
	</tr>
	<c:forEach var="g" items="${GLlist}">
		<tr>
			<td>${g.businessName}</td>
			<td>${g.address}</td>
		</tr>
	</c:forEach>
</table>
<form action = "/add_to_my_houses/${address }">
<input type = "submit" value="Add to Favorites"></form>

${gl}

</body>
</html>