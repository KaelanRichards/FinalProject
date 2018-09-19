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
	<style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
    </style>
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
      	<a class="nav-link" href="/logout">Log Out</a>
      </li>
    </ul>
  </div>
</nav>
	${result}


	<div class="container">
	<h1>Your Crime Safety Rating Is</h1>
	<h1>>>>${safetyString }<<<</h1>
	<form action="/add_to_my_houses/${address }">
		<input class="btn btn-warning" type="submit" value="Add to Favorites">
	</form>
	</div>
	<div class="container">
	<h6>__________________________________________________________________________</h6>
	<h3>Crime Details</h3>
	<p>Larceny: ${larceny}</p>
	<p>Stolen Vehicles: ${stolenVehicle}</p>
	<p>Burglaries: ${burglary}</p>
	<p>Sexual Assaults: ${sexualAssault}</p>
	<p>Robberies: ${robbery}</p>
	<p>Assaults: ${assault}</p>
	<p>Aggr. Assaults: ${aggravatedAssault}</p>
	</div>
	<div class="container">
	<h6>__________________________________________________________________________</h6>
	<h3>Police Department information</h3>
	<h5>Your Closest Precinct: ${yourPrecinct}</h5>
	<h5>Department:</h5>
	<p>${precinctInfo[0] }</p>
	<h5>Address:</h5>
	<p>${precinctInfo[1] }</p>
	<h5>Contact Information:</h5>
	<p>${precinctInfo[2] }</p>
	<h6>__________________________________________________________________________</h6>
	<h1>Project GreenLight Participants Near You</h1>
	</div>
	<div class="container">
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
	</div>
	
	${gl}
	
    <!--The div element for the map -->
    <div id="map" class="container">
    <h3>Your pinned location</h3>
    </div>
	<script>
		// Initialize and add the map
		function initMap() {
			// The location of Uluru
			var userLocation = {
				lat : ${latitude},
				lng : ${longitude}
			};
			// The map, centered at user location
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 17,
				center : userLocation
			});
			// The marker, positioned at User location
			var marker = new google.maps.Marker({
				position : userLocation,
				map : map
			});
		}
	</script>
	<!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y&callback=initMap">
		
	</script>
</body>
</html>