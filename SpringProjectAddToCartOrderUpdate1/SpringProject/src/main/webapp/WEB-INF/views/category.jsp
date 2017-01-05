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
<h2>Category Information</h2>
 <center>


  <c:if test="${!empty categoryList}">
   <table border="1" bgcolor="black" width="600px">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     
     <td>id</td>
     <td>Category</td>
 
    <td>Edit</td>
    <td>Delete</td>
    </tr>
    <c:forEach items="${categoryList}" var="ctg">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><h3><c:out value="${ctg.categoryId}" /></h3>
      </td>
       <td><h3><c:out value="${ctg.categoryName}" /></h3>
      <td><h3><c:out value="${ctg.products.get(0).id}" /></h3>
      <td><h3><c:out value="${ctg.products.get(0).name}" /></h3>
       <td><h3><c:out value="${ctg.products.get(0).quantity}" /></h3>
        <td><h3><c:out value="${ctg.products.get(0). price}" /></h3>  
        
           <td><h3><a href="editCategory?sp=${ctg.categoryId}">Edit</a></h3></td>
      <td><h3><a href="deleteCategory?sp=${ctg.categoryId}">Delete</a></h3></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>
  
  
  <a href="Admin">Click Here to add new User</a>
   
</center>
 
</body>
</html>