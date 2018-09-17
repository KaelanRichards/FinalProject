<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Places</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>
${favoriteItem }<br><br>

Test ${requestScope.favid}<br><br>
		<div class="form-group">
		<form action="/edit" method="post">
		
            
                <label >Address</label>
                <!-- pre-populate the input value from the existing food (if any) -->
                <input class="form-control" id="address" name="address"
                    value="${favAddress}" required minLength="2" autocomplete="off" readonly = "readonly">
                     <label >Category</label>
                     <input type="hidden" value="${requestScope.favid}" name="id">
                <!-- pre-populate the input value from the existing food (if any) -->
                <select name="category">
                	<option value="">(None)</option>
                	<option value="Home">Home</option>
                	<option value="Business">Business</option>
                	<option value="Restaurant">Restaurant</option>
                	<option value="Other">Other</option>
                </select>
            
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/" class="btn btn-link">Cancel</a>
            
        </form>
        </div>

</body>
</html>