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
     <td>sup1</td>
     <td>sup2</td>
    <td>sup3</td>
    <td>sup4</td>
    <td>sup5</td>
    <td>sup6</td>
    <td>sup7</td>
    <td>sup8</td>
    <td>product</td>
    </tr>
    <c:forEach items="${categoryList}" var="ctg">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><c:out value="${ctg.sp}" />
      </td>
      <td><c:out value="${ctg.sup1}" />
      </td>
      <td><c:out value="${ctg.sup2}" />
      </td>
       <td><c:out value="${ctg.sup3}" />
      </td>
       <td><c:out value="${ctg.sup4}" />
      </td>
       <td><c:out value="${ctg.sup5}" />
      </td>
       <td><c:out value="${ctg.sup6}" />
      </td>
       <td><c:out value="${ctg.sup7}" />
      </td>
       <td><c:out value="${ctg.sup8}" />
      </td>
       <td><c:out value="${ctg.img}" /><img src="<c:url value = '/resources/images/${ctg.img}.jpg'/>"alt="test" class="img-responsive" style="width:40px;height:37px"/>
       
      </td>
           <td><a href="editCategory?sp=${ctg.sp}">Edit</a></td>
      <td><a href="deleteCategory?sp=${ctg.sp}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>
  
  
  <a href="Admin">Click Here to add new User</a>
   

  
  
  
  
  
  
  <%-- <img src="<c:url value='/resources/images/cokr1.jpeg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
 <img src="<c:url value='${ctg.img}'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/> --%>
</body>
</html>