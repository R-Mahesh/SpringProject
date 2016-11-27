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
	<c:if test="${!empty productList}">
		<table border="1" bgcolor="black" width="600px">
			<tr style="background-color: teal; color: white; text-align: center;"
				height="40px">

				<td>category</td>
				<td>quantity</td>
				<td>price</td>
				<td>description</td>
				<td>name</td>








			</tr>
			<c:forEach items="${productList}" var="ctg">
				<tr
					style="background-color: white; color: black; text-align: center;"
					height="30px">

					<td><c:out value="${ctg.category}" /></td>
					<%--  <td><c:out value="${ctg.name}" />
      </td> --%>
					<td><c:out value="${ctg.quantity}" /></td>
					<td><c:out value="${ctg.price}" /></td>
					<td><c:out value="${ctg.description}" /></td>
					<td><c:out value="${ctg.name}" /><img
						src="<c:url value = '/resources/images/${ctg.name}.jpg'/>"
						alt="test" class="img-responsive"
						style="width: 40px; height: 37px" /></td>
					<td><a href="editProduct?id=${ctg.id}">Edit</a></td>
					<td><a href="deleteProduct?id=${ctg.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>