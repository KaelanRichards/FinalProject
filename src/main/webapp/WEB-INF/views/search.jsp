<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crime-Spy (Detroit edition) home page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cerulean/bootstrap.min.css" />
</head>
<body background = "http://www.designcities.net/wp-content/uploads/2016/01/Skyline-photo-copyright-Detroit-Creative-Corridor-Center-photo-by-Stephen-McGeee_kl.jpg">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="/search" >DETROIT</a>
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
      	<a class="nav-link" href="/search/logout">Log Out</a>
      </li>
    </ul>
  </div>
</nav>

<section id="cover">
    <div id="cover-caption" >
        <div id="container" class="container">
            <div class="row text-white">
                <div class="col-sm-10 offset-sm-1 text-center">
                    <h1  class="display-3 text-info" style = "padding-top: 112px" font-color: green>Explore Detroit</h1>
                    <div class="info-form">
                        <form action="/result" class="form-inline justify-content-center">
                            
                            <div class="form-group">
                                
                                
                                <input name="address" type="text" class="form-control" placeholder="Street Address">
                                <input name="city" type="text" class="form-control"  value="Detroit" readonly="readonly">
                                <input name="state" type="text" class="form-control"  value="MI" readonly="readonly">
                            </div>
                     		
                            <button  type="submit" class="btn btn-primary" >Search!</button>
                            
                        </form>
                    </div>
                    <br>

                    
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>