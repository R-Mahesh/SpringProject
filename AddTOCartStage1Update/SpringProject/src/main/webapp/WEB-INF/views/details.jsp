<%@include file="./header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">

	<div class="row text-center">
		<div class="col-xs-4 col-sm-3">
			<div class="thumbnail">
				<a href="#"><img
					src="<c:url value='/resources/images/${productDetail.name}.jpg'/>"
					alt="test" class="img-responsive"
					style="width: 300px; height: 370px" /></a>
				
			</div>
		</div>
		<div class="col-xs-4 col-sm-3">
		<div class="jumbotron" style="width:500px;height:400px"> 
	PRICE	<p>
					&#x20B9<strong>${productDetail.price}</strong>
				</p>
			QUANTITY AVAILABLE	<p>${productDetail.quantity}</p>
				<p>${productDetail.description}</p>
		 <form:form modelAttribute="myCart"
		action="addToCart">
 <c:if test="${!empty userDetail}">
			<c:forEach items="${userDetail}" var="userdetail">
				<form:hidden path="user_id" value="${userdetail.id}" />
			</c:forEach>
		</c:if>
		
		<form:hidden path="product_Name" value="${productDetail.name}" />
		<form:hidden path="product_id" value="${productDetail.id}" />
		<form:hidden path="price" value="${productDetail.price}" /> 
		<form:hidden path="totalPrice" value="${productDetail.price}" />
				<form:hidden path="quantity" value="1" />
		<input type="submit" value="Add To cart" class="btn btn-danger"  style="width:50%" />
	</form:form>
 
		
		<%-- <c:if test="${!empty userDetail}">
			<div class="col-xs-4 col-sm-3">
				<c:forEach items="${userDetail}" var="userdetail">
				${userdetail.userName}
				${userdetail.id}
				</c:forEach>
			</div>
		</c:if>
		<% java.util.Date now=new java.util.Date();	%>
		<%=now %> --%>
	</div>
	</div>
	</div>
</body>
</html>