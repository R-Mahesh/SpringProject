<%@include file="./header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="details">
<input type="number" name="action">
<input type="submit"  value="GETDETAILS"/>
</form>
<center>

  <div style="color: teal; font-size: 30px">
   Edit Details</div>



   <table width="400px" height="150px">
    <tr>
     <td>ID</td>
     <td>${employeeObject.id}</td>
    </tr>
    <tr>
     <td>Name</td>
     <td>${employeeObject.name}</td>
    </tr>
    <tr>
     <td>Age</td>
     <td>${employeeObject.age}</td>
    </tr>
   
    
   </table>


  
 </center>
${message}
</body>
</html>