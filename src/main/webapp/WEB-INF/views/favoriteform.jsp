<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>
${listFavs }
<form action="favorites">
            <div class="form-group">
                <label >Address</label>
                <!-- pre-populate the input value from the existing food (if any) -->
                <input class="form-control" id="address" name="address"
                    value="${f.address}" required minLength="2" autocomplete="off">
                     <label >Category</label>
                <!-- pre-populate the input value from the existing food (if any) -->
                <input class="form-control" id="category" name="category"
                    value="${f.category}" required minLength="2" autocomplete="off">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/" class="btn btn-link">Cancel</a>
        </form>

</body>
</html>