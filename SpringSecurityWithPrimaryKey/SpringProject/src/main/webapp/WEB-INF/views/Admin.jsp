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

<form:form  modelAttribute="category" method="POST" action="./addSuppliers" enctype="multipart/form-data">
   <table>
    <tr>
    <td><form:label path="sup1">Supplier1</form:label></td>
   
  
        <td><form:input path="sup1" /></td>
          <td><form:errors path="sup1" cssClass="error" /></td>
    </tr>
    <tr>
       <td><form:label path="sup2">Supplier2</form:label></td>
        <td><form:input path="sup2" /></td>
    </tr>
     <tr>
       <td><form:label path="sup3">Supplier3</form:label></td>
        <td><form:input path="sup3" /></td>
    </tr>
     
     <tr>
       <td><form:label path="sup4">Supplier4</form:label></td>
        <td><form:input path="sup4" /></td>
    </tr>
     <tr>
       <td><form:label path="sup5">Supplier5</form:label></td>
        <td><form:input path="sup5" /></td>
    </tr>
     <tr>
       <td><form:label path="sup6">Supplier6</form:label></td>
        <td><form:input path="sup6" /></td>
    </tr>
     <tr>
       <td><form:label path="sup7">Supplier7</form:label></td>
        <td><form:input path="sup7" /></td>
    </tr>
     <tr>
       <td><form:label path="sup8">Supplier8</form:label></td>
        <td><form:input path="sup8" /></td>
    </tr>
  <tr>
   <td>
	File to upload: <input type="file" name="file"/>
	<input type="text" name="name"/>
	</td>
    </tr> 
    
    <tr>
<%--        <td><form:label path="sup8">Supplier8</form:label></td> --%>
        <td><%-- <form:hidden path="img" value="${imgsrc}" /> --%></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"  value="Add"/>
            
        </td>
    </tr>
</table>  
</form:form>
		
<a href="categorylist">Click Here to see Category List</a>
<a href="listUser">Click Here to see user List</a>
<a href="category">Click Here to see  edit options</a>
<a href="productList">Click Here to see  edit Product options</a>
<center><a href="productsForm" style="color:black">Click here to Add new Products</a></center>
<div>
<img src="<c:url value = '/resources/images/${img}.jpg'/>"alt="test" class="img-responsive" />
</div>
${message}

</body>
</html>