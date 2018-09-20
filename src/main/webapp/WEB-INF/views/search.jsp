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
      <li class="nav-item"><a class="nav-link" href="/favorites"> My Favorites</a>
			</li>
      <li class="nav-item">
      	<a class="nav-link" href="/resources">Resources</a>
      </li>
      <li class="nav-item">
      	
      </li>
     
    </ul>
     <a class="nav-link" href="/logout" align = "right">Log Out</a>
      
      <img align = "right" src = "images/test1.jpg" width="40" height="40">
  </div>
</nav>

<section id="cover">
    <div id="cover-caption" >
        <div id="container" class="container">
        <h1 class ="row text-white">${message}${login}</h1>
            <div class="row text-white">
                <div class="col-sm-10 offset-sm-1 text-center">
                <img src = "images/IMG_6740.PNG" width="200" height="200">
              
                    <h1  class="display-2 text-info" style = "padding-top: 1px">Explore Detroit</h1>
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