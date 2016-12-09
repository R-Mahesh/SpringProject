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

<h2>Submitted Student Information</h2>
 <center>


 <c:if test="${!empty userList}">
   <table border="1" bgcolor="black" width="600px">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     
     <td>id</td>
     <td>Name</td>
     <td>Enable</td>
     <td>Edit</td>
    <td>Delete</td>
    </tr>
    <c:forEach items="${userList}" var="user">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><c:out value="${user.id}" />
      </td>
      <td><c:out value="${user.name}" />
       </td>
     
       <td><c:out value="${user.enabled}" />
      </td> 
     
           <td><a href="editUser?id=${user.id}">Edit</a></td>
      <td><a href="deleteUser?id=${user.id}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>


  <a href="register">Click Here to add new User</a>
 ${message}
   
</center>
</body>
</html>