<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>${safetyString }</h1>
<h6>__________________________________________________________________________</h6>
<h4>Larceny:         ${scores16}</h4>
<h4>Stolen Vehicles: ${scores17}</h4>
<h4>Burglaries:      ${scores18}</h4>
<h4>Sexual Assaults: ${scores17}</h4>
<h4>Robberies:       ${scores18}</h4>
<h4>Assaults:        ${scores17}</h4>
<h4>Aggr. Assaults:  ${scores18}</h4>
<h6>__________________________________________________________________________</h6>
<h5>Your Closest Precinct: ${yourPrecinct}</h5>

<form action = "/add_to_my_houses"><input type = "submit" value="Add to Favorites"></form>
${safetyString }

${gl}

</body>
</html>