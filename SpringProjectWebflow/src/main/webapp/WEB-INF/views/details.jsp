<%@include file="./header.jsp" %>
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

	${productDetail.id}
				${productDetail.name}
				${productDetail.quantity}
				${productDetail.price}
				${productDetail.description}
					<div class="row text-center">
				<div class="col-xs-4 col-sm-3">
					<div class="thumbnail">
						<a href="#"><img
							src="<c:url value='/resources/images/${productDetail.name}.jpg'/>"
							alt="test" class="img-responsive"
							style="width: 300px; height: 370px" /></a>
						<p>
							&#x20B9<strong>${productDetail.price}</strong>
						</p>
						<p>${productDetail.quantity}</p>
						<p>${productDetail.description}</p>
							</div>
				</div>
				<c:if test="${!empty userDetail}">
				<div class="col-xs-4 col-sm-3">
				<c:forEach items="${userDetail}" var="userdetail">
				${userdetail.userName}
				${userdetail.id}
				</c:forEach>
				</div>
	</c:if>
				
</div>
<form:form modelAttribute="myCart" action="addToCart">
<c:if test="${!empty userDetail}">
<c:forEach items="${userDetail}" var="userdetail">
					<form:hidden path="user_id" value="${userdetail.id}"/>
					</c:forEach>
					</c:if>
					<form:hidden path="product_id" value="1"/>
					<form:hidden path="price" value="${productDetail.price}"/>
					Enter Quantity<form:input path="quantity" />
					<input type="submit" value="Add To cart"/>
				</form:form> 
				
							
				
</body>
</html>