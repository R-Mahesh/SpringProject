<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center><a href="index" class="btn btn-info" role="button">Home</a></center>
	 <form:form action="register" modelAttribute="insertTable">
									<div class="form-group">
										<form:label path="name">
											<span class="glyphicon glyphicon-user"></span> Username</form:label>
										<form:input type="text" class="form-control" path="name"
											 placeholder="Enter name" />
									</div>
									<div class="form-group">
										<form:label path="password">
											<span class="glyphicon glyphicon-eye-open"></span> Age</form:label>
										<form:input type="number" class="form-control"
											path="age"  placeholder="Enter password" />
									</div>
									<div class="form-group">
										<form:label path="password">
											<span class="glyphicon glyphicon-eye-open"></span> Password</form:label>
										<form:input type="password" class="form-control"
											path="password"  placeholder="Enter password" />
									</div>
									
									
									<button type="submit" class="btn btn-success btn-block">
										<span class="glyphicon glyphicon-off"></span> Register
									</button>
								</form:form>
</body>
</html>