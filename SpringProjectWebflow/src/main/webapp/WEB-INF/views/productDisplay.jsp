<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
			<c:forEach items="${productList}" var="product">
				<div class="col-xs-6 col-sm-3">
					<div class="thumbnail">
						<a href="#"><img
							src="<c:url value='/resources/images/${product.name}.jpg'/>"
							alt="test" class="img-responsive"
							style="width: 4000px; height: 370px" /></a>
						<p>
							&#x20B9<strong>${product.price}</strong>
						</p>
						<p>${product.description}</p>
						<sec:authorize access="hasRole('ROLE_USER')">
						<a href="details?productId=${product.id}"><button class="btn">Buy Now</button></a>
						</sec:authorize>
						
						<%-- <sec:authorize access="hasRole('ROLE_USER')">
						${pageContext.request.userPrincipal.name}
						<a href="Buy now"><button class="btn">Add To Cart</button></a>
						</sec:authorize> --%>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="editProduct?id=${product.id}"><button class="btn">Edit</button></a>
							<a href="deleteProduct?id=${product.id}"><button class="btn">Delete</button></a>
						</sec:authorize>
					</div>
				</div>
			</c:forEach>


		</div>
	</c:if>
	<%-- <c:if test="${!empty productList}">
	<c:forEach items="${productList}" var="product">
	<c:if test="${!empty userDetail}">
				<c:forEach items="${userDetail}" var="userdetail">
	<form:form modelAttribute="myCart" action="addToCart"><!--  -->
					<form:hidden path="user_id" value="${userdetail.id}"/>
					<form:hidden path="product_id" value="${product.id}"/>
					<form:hidden path="price" value="${product.price}"/>
					<form:hidden path="quantity" value="${product.quantity}"/>
					<sec:authorize access="hasRole('ROLE_USER')">
						<a href="Buy now"><button class="btn">Add To Cart</button></a>
						</sec:authorize>
					<!-- <input  type="submit" value="Confirm Details" class="btn btn-danger"  style="width:200px"/><br /> -->
				</form:form> 
				</c:forEach>
	</c:if>
	</c:forEach>
	</c:if> --%>
				<c:if test="${!empty userDetail}">
				<c:forEach items="${userDetail}" var="userdetail">
				${detail.userName}
				${detail.id}
				</c:forEach>
	</c:if>
</body>
</html>