<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>
<div class="container">
 	<h1>Hello Whirled...</h1>
 	
 	
 	
 	<table border="1">
 	
 	<tr>
	<th>Arrest Charge</th>
	<th>Charge Description</th>
	<th>Crime ID</th>
	<th>Date</th>
	<th>Neighborhood</th>
	<th>Scout Car</th>
	<th>Hour of Day</th>
	<th>Offense Category</th>
	<th>Precinct Number</th>
	<th>Year</th>
	<th>Longitude</th>
	<th>Latitude</th>
	</tr>
<!-- this for each loop works just like an enhanced for loop in java -->
<c:forEach var="print" items="${test}" >
	
	
	
	
	<tr>
	
	<td>${print.arrestCharge}</td>
	<td>${print.chargeDesc}</td>
	<td>${print.crimeId}</td>
	<td>${print.date}</td>
	<td>${print.neighborhood}</td>
	<td>${print.scoutCar}</td>
	<td>${print.hourOfDay}</td>
	<td>${print.offenseCategory}</td>
	<td>${print.precinct}</td>
	<td>${print.year}</td>
	<td>${print.longitude}</td>
	<td>${print.latitude}</td>
	
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>