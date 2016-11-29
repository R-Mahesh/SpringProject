<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<center>
			<a href="productsForm" style="color: black">Click here to Add new
				Products</a>
		</center>
	</sec:authorize>
	<c:if test="${!empty productList}">

		<div class="row text-center">
			<c:forEach items="${productList}" var="ctg">
				<div class="col-xs-6 col-sm-3">
					<div class="thumbnail">
						<a href="#"><img
							src="<c:url value='/resources/images/${ctg.name}.jpg'/>"
							alt="test" class="img-responsive"
							style="width: 4000px; height: 370px" /></a>
						<p>
							&#x20B9<strong>${ctg.price}</strong>
						</p>
						<p>${ctg.description}</p>
						<!-- <button class="btn" toggle="modal" target="#myModal">Buy now</button> -->
						<a href="Buy now"><button class="btn">Buy now</button></a>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="editProduct?id=${ctg.id}"><button class="btn">Edit</button></a>
							<a href="deleteProduct?id=${ctg.id}"><button class="btn">Delete</button></a>
						</sec:authorize>
					</div>
				</div>
			</c:forEach>


		</div>
	</c:if>
</body>
</html>