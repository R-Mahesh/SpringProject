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



  <form:form  commandName="categoryEntity" method="post"
   action="updateCategory" enctype="multipart/form-data">
   <table width="400px" height="150px">
    <tr>
     <td><form:hidden path="categoryId" value="${categoryObject.categoryId}" /></td>
    </tr>
    <tr>
     <td><form:label path="categoryName">categoryName</form:label></td>
     <td><form:input path="categoryName" value="${categoryObject.categoryName}"/></td>
      <td><form:errors path="categoryName" cssClass="error" /></td>
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