<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response table</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<h1>Hello Whirled...</h1>



		<table border="1">

			<tr>
				<th>Neighborhood</th>
				<th>Total Response Time</th>
				<th>Longitude</th>
				<th>Latitude</th>
		
				
			</tr>
			<!-- this for each loop works just like an enhanced for loop in java -->
			<c:forEach var="print" items="${response}">




				<tr>

					<td>${print.neighborhood}</td>
					<td>${print.totalresponsetime}</td>
					<td>${print.longitude}</td>
					<td>${print.latitude}</td>
					

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>