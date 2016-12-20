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



  <form:form  commandName="user" method="post"
   action="updateUser">
   <table width="400px" height="150px">
    <tr>
     <td>ID</td>
     <td>${userObject.id}</td>
    </tr>
    <tr>
     <td><form:label path="userName">Name</form:label></td>
     <td><form:input path="userName" value="${userObject.userName}"/></td>
     <td><form:errors path="userName" cssClass="error" /></td>
    </tr>
    <tr>
      <tr>
    
     <td><form:label path="enabled">Enable</form:label></td>
     <td><form:input path="enabled" value="${userObject.enabled}"/></td>
     <td><form:errors path="enabled" cssClass="error" /></td>
    </tr>
     
   <tr>
     <td><form:label path="password">PassWord</form:label></td>
     <td><form:input path="password" value="${userObject.password}"/></td>
    </tr>
    <tr>
     <td><form:hidden path="confirmPassWord" value="${userObject.passWord}"/></td>
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
