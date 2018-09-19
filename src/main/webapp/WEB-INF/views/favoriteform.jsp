<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Places</title>

<title>Crime-Spy (Detroit edition) home page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cerulean/bootstrap.min.css" />
</head>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/">DETROIT</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/index">Log
					In <span class="sr-only"></span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/display">Register</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/resources">Resources</a>
			</li>
			<li class="nav-item">
				<!-- need to redirect to search page after invalidating the http session
      request mapping to logout controller method and then use redirect for the modelandview jsp page? -->
				<a class="nav-link" href="/logout">Log Out</a>
			</li>
		</ul>
	</div>
</nav>


<div class="form-group">
	<form action="/edit" method="post">


		<label>Address</label>
		<!-- pre-populate the input value from the existing food (if any) -->
		<input class="form-control" id="address" name="address"
			value="${favAddress}" required minLength="2" autocomplete="off"
			readonly="readonly"> <label>Category</label> <input
			type="hidden" value="${requestScope.favid}" name="id">
		<!-- pre-populate the input value from the existing food (if any) -->
		<select name="category">
			<option value="">(None)</option>
			<option value="Home">Home</option>
			<option value="Business">Business</option>
			<option value="Restaurant">Restaurant</option>
			<option value="Bar">Bar</option>
			<option value="Park">Park</option>

			<option value="Other">Other</option>
		</select>

		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/" class="btn btn-link">Cancel</a>

	</form>
</div>

</body>
</html>