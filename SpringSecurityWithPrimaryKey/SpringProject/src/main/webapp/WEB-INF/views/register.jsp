<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	 <form:form  modelAttribute="user" method="POST" action="addUser" >
   <table>
<%-- <!--     <tr> -->
     <td><form:label path="id">id</form:label></td>
        <td><form:input path="id" /></td>
<!--     </tr> --> --%>
    <tr>
    <td><form:label path="name" >Name</form:label></td>
     
        <td><form:input path="name" name="name"/></td>
        <td><form:errors path="name"/></td>
    </tr>
    <tr>
       <td><form:label path="password">password</form:label></td>
        <td><form:input type="password" path="password"  name="password"/></td>
        <td><form:errors path="password"  /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"  value="Add"/>
            
        </td>
    </tr>
</table>  

</form:form> 
<%--  <c:url value='j_spring_security_check' />   --%>
	
</body>
</html>
