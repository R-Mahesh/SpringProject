<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
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
						<sec:authorize access="isAnonymous()">
						<a href="memberShip.obj"><button class="btn">Details</button></a>
						</sec:authorize>
						
						<sec:authorize access="hasRole('ROLE_USER')">
						<a href="Buy now"><button class="btn">Details</button></a>
						</sec:authorize>
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