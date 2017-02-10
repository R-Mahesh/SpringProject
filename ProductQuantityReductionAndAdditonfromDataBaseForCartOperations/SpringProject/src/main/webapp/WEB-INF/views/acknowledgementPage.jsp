<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<
</head>
<body background="<c:url value='/resources/images/ThankU1.jpg'/>">
 <h1><span style="color:red">Thank you PRODUCTS DELIVERED SHORTLY /Please  LogIn To your E-Mail To See your Purchase Details </span></h1>
<div class="row" style=" position:absolute; top:10%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:60px;
    z-index:60;">
 <h2> <a href="${flowExecutionUrl}&_eventId_home" style="color: red">Press Here to go Back</a></h2>
</div>
</body>
</html>