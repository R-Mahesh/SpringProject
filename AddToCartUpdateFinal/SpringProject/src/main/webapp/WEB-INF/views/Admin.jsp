<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>uploading file</title>

<style>
.error {
	color: #ff0000;
}

/*.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}*/
</style>

</head>
<body>

<form:form  modelAttribute="categoryEntity" method="POST" action="./addSuppliers" enctype="multipart/form-data">
   <table>
    <tr>
    <td><form:label path="categoryName">CATEGORY</form:label></td>
   
  
        <td><form:input path="categoryName" /></td>
          <td><form:errors path="categoryName" cssClass="error" /></td>
    </tr>
  
    <tr>
        <td colspan="2">
            <input type="submit"  value="Add"/>
            
        </td>
    </tr>
</table>  
</form:form>
<center>
<table>
<tr>
<td>

<h3>
<a href="categorylist">Click Here to see Category List</a>
</h3>

</td>
</tr>
<tr>
<td>

<h3><a href="listUser">Click Here to see user List</a>
</h3>

</td>
</tr>
<tr>
<td>
<h3>
<a href="category">Click Here to see  edit options</a></h3>

</td>
</tr>
<tr>
<td>
<h3>
<a href="productList">Click Here to see  edit Product options</a></h3>

</td>
</tr>
<tr>
<td>
<h3>
<a href="productsForm" style="color:black">Click here to Add new Products</a></h3>

</td>
</tr>
</table>
</center>
</body>
</html>