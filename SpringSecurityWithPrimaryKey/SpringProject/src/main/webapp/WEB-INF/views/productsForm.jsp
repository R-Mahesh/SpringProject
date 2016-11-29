<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
<center>
 <form:form  modelAttribute="products" method="POST" action="./addProducts" enctype="multipart/form-data">
   
   
  
   <table>
    
       <%-- <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category" /></td> --%>
        <tr>
        <td>Select Category</td>
        <td>
 <form:select path="category" class="form-control">
 <c:if test="${!empty categoryList}">
 <c:forEach items="${categoryList}" var="ctg">
					  <form:option value="${ctg.sup1}"  />
					   <form:option value="${ctg.sup2}"  />
					    <form:option value="${ctg.sup3}"  />
					     <form:option value="${ctg.sup4}"  />
					      <form:option value="${ctg.sup5}"  />
					       <form:option value="${ctg.sup6}"  />
					        <form:option value="${ctg.sup7}"  />
					         <form:option value="${ctg.sup8}"  />
					         </c:forEach>
					          </c:if>
				       </form:select>
</td>
 </tr>     
        
    
    <tr>
    <td><form:label path="name">Name</form:label></td>  
        <td><form:input path="name"  class="form-control"/></td>
          <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
       <td><form:label path="quantity">Quantity</form:label></td>
        <td><form:input path="quantity"  class="form-control"/></td>
    </tr>
     <tr>
       <td><form:label path="price">Price </form:label></td>
        <td><form:input path="price"  class="form-control"/></td>
    </tr> 
   
        <tr>
       <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description"  class="form-control"/></td>
    </tr>  
  <tr>
   <td>
	File to upload: <input type="file" name="file"  class="form-control"/>
	</td>
    </tr> 
    
    <tr>
<%--        <td><form:label path="sup8">Supplier8</form:label></td> --%>
        <td><%-- <form:hidden path="img" value="${imgsrc}" /> --%></td>
    </tr>
    
    <tr>
        <td colspan="2">
        <center>
            <input type="submit"  value="Add"  class="form-control" style="width:50%"/>
              </center>
        </td>
      
    </tr>
    
</table>  

</form:form>
<!-- <div>
    <input type="file" name="file">
    </div> -->
</center>
${message}
<img src="<c:url value = '/resources/images/${img}.jpg'/>"alt="test" class="img-responsive" />
</body>
</html>