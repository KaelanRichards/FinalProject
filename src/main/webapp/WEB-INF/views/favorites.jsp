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
${user.username}
	<table>
				<!-- this for each loop works just like an enhanced for loop in java -->
			<c:forEach var="f" items="${listFavs}">
					<tr>
						<td>${f.address}</td>
						<td>Score</td>
						<td><a href="/edit/${f.favid}">Edit</a></td>
						<td><a href="/delete/${f.favid}">Delete</a></td>
						
					</tr>
			</c:forEach>
	</table>


</body>
</html>