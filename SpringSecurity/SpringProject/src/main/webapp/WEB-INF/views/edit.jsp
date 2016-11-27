<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Edit User Details</title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px">
   Edit Details</div>



  <form:form  commandName="emp" method="post"
   action="update">
   <table width="400px" height="150px">
    <tr>
     <td><form:label path="id">ID</form:label></td>
     <td><form:input path="id" value="${employeeObject.id}" /></td>
    </tr>
    <tr>
    
     <td><form:label path="name">Name</form:label></td>
     <td><form:input path="name" value="${employeeObject.name}"/></td>
     <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
     
     <td><form:label path="phoneNumber">PhoneNumber</form:label></td>
     <td><form:input path="phoneNumber" value="${employeeObject.phoneNumber}"/></td>
          <td><form:errors path="phoneNumber" cssClass="error" /></td>
   
    </tr>
   <tr>
     <td><form:label path="password">PassWord</form:label></td>
     <td><form:input path="password" value="${employeeObject.password}"/></td>
    </tr>
    
    <tr>
     <td><input type="submit" value="Update" />
     </td>
    </tr>
   </table>
  </form:form>


  
 </center>
</body>
</html>
