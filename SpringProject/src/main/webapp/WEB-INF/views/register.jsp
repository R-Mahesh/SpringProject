<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<form:form  commandName="emp" method="POST" action="./add">
   <table>
<!--     <tr> -->
<%--      <td><form:label path="id">id</form:label></td> --%>
<%--         <td><form:input path="id" /></td> --%>
<!--     </tr> -->
    <tr>
    <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
       <td><form:label path="age">Age</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"  value="Add"/>
            
        </td>
    </tr>
</table>  
</form:form>

</body>
</html>
