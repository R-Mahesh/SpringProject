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



  <form:form  commandName="category" method="post"
   action="updateCategory" enctype="multipart/form-data">
   <table width="400px" height="150px">
    <tr>
     <td><form:hidden path="sp" value="${categoryObject.sp}" /></td>
    </tr>
    <tr>
     <td><form:label path="sup1">Supplier1</form:label></td>
     <td><form:input path="sup1" value="${categoryObject.sup1}"/></td>
      <td><form:errors path="sup1" cssClass="error" /></td>
    </tr>
    <tr>
     <td><form:label path="sup2">Supplier2</form:label></td>
     <td><form:input path="sup2" value="${categoryObject.sup2}"/></td>
    </tr>
     <tr>
     <td><form:label path="sup3">Supplier3</form:label></td>
     <td><form:input path="sup3" value="${categoryObject.sup3}"/></td>
    </tr>
    <tr>
     <td><form:label path="sup4">Supplier4</form:label></td>
     <td><form:input path="sup4" value="${categoryObject.sup4}"/></td>
    </tr>
    <tr>
     <td><form:label path="sup5">Supplier5</form:label></td>
     <td><form:input path="sup5" value="${categoryObject.sup5}"/></td>
    </tr>
    <tr>
     <td><form:label path="sup6">Supplier6</form:label></td>
     <td><form:input path="sup6" value="${categoryObject.sup6}"/></td>
    </tr>
    <tr>
     <td><form:label path="sup7">Supplier7</form:label></td>
     <td><form:input path="sup7" value="${categoryObject.sup7}"/></td>
    </tr>
    <tr>
     <td><form:label path="sup8">Supplier8</form:label></td>
     <td><form:input path="sup8" value="${categoryObject.sup8}"/></td>
    </tr>
    <tr>
    <td>productImg<input type="file" name="file"/></td>
     <td><form:input path="img" value="${categoryObject.img}"/></td>
    </tr>
     <tr>
  
    <tr>
     <td><input type="submit" value="Update" />
     </td>
    </tr>
   </table>
  </form:form>


  
 </center>
</body>
</html>