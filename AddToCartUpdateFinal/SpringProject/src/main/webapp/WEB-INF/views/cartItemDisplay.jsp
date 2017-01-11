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
<body background="<c:url value='/resources/images/u5c8E.gif'/>">

<center>


 <c:if test="${!empty cartItem}">
   <table border="1" bgcolor="black" width="600px">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     <td>img</td>
     <td>product</td>
     <td>price</td>
     <td>quantity</td>
     <td>TotalPrice</td>  
    <td>Delete</td>
    </tr>
    <c:forEach items="${cartItem}" var="product">
    
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
     <td class="active"  style="color:white"><b><img src="<c:url value='/resources/images/${product.product_Name}.jpg'/>" alt="test"  class="img-responsive" alt="Chania" style="width:40px;height:30px"/></b></td>
       <td><c:out value="${product.product_Name}" />
      </td> 
        <td><c:out value="${product.price}" />
      </td> 
      <td><c:out value="${product.quantity}" />
      </td> 
       <td><c:out value="${product.totalPrice}" />
      </td> 
      
      <td><a href="deleteCart?cartId=${product.cart_id}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>
</center>
<div class="row">
<div class="col-md-4 col-md-offset-5">
 <div   class="form-group">
 
 	<a href="productList"><input  type="submit"  value="ContinueShopping" class="btn btn-default" /></a>
 	 <c:if test="${!empty cartItem}">
					<a href="orderAndShipping.obj"><input  type="submit" value="CheckOut" class="btn btn-danger" /></a> 
					</c:if>
					 </div>
					 <c:if test="${empty cartItem}">
 <span style="color: red">Your Cart is empty you can view our products by clicking ContinueShopping </span>
 </c:if>
  <span style="color:red"> ${grandTotal} </span>
        </div>
       
        </div>
      
</body>
</html>