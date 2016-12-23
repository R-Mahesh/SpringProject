<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

  <div style="color: teal; font-size: 30px">
   Edit Details</div>



  <form:form  modelAttribute="products" method="post"
   action="updateProduct" enctype="multipart/form-data">
   <table width="400px" height="150px">
    <tr>
     <td><form:hidden path="id" value="${productsObject.id}" /></td>
    </tr> 
    <%--  <tr>
     <td><form:hidden path="category" value="${productsObject.category}" /></td>
    </tr>  --%>
     
      <tr>
     <td><form:label path="category">Category</form:label></td>
     <td><form:input path="category" value="${productsObject.category}"/></td>
    </tr> 
  <%--   <tr>
     <td><form:label path="name">Name</form:label></td>
     <td><form:input path="name" value="${productsObject.name}"/></td>
      <td><form:errors path="name" cssClass="error" /></td>
    </tr> --%>
    <tr>
     <td><form:label path="quantity">Quantity</form:label></td>
     <td><form:input path="quantity" value="${productsObject.quantity}"/></td>
    </tr>
     <tr>
     <td><form:label path="price">price</form:label></td>
     <td><form:input path="price" value="${productsObject.price}"/></td>
    </tr>
    <tr>
     <td><form:label path="description">Description</form:label></td>
     <td><form:input path="description" value="${productsObject.description}"/></td>
    </tr>
   
    <tr>
    <td>productImg<input type="file" name="file"/></td>
     <td><form:input path="name" value="${productsObject.name}"/></td>
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
     <tr>
  
    <tr>
     <td><input type="submit" value="Update" />
     </td>
    </tr>
   </table>
  </form:form>


  
 </center>
</body>
</html>