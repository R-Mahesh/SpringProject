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

<div class="row">
<div class="col-md-6 col-md-offset-3">
<div class="jumbotron" style="width:500px;height:400px"> 
 <form:form  modelAttribute="products" method="POST" action="./addProducts" enctype="multipart/form-data">
   
   
  
   
    
       <%-- <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category" /></td> --%>
      <div class="form-group">   
        <label class="col-md-4 control-label"> Select Category</label>
   <div class="input-group col-md-7">      
 <%-- <form:select path="category" class="form-control">
 <c:if test="${!empty categoryList}">
 <c:forEach items="${categoryList}" var="ctg">
					  <form:option value="${ctg.categoryName}"  />
							         </c:forEach>
					          </c:if>
				       </form:select>
 --%> 
 <form:input  path="category" />
      </div>  
     </div>
     <div class="form-group">
     <label class="col-md-4 control-label">Name</label>
     <div class="input-group col-md-7"> 
        <form:input path="name" name="name" class="form-control"/>
          <form:errors path="name" cssClass="error" />
          </div> </div>
           <div class="form-group">
    
      <label class="col-md-4 control-label">Quantity</label><div class="input-group col-md-7"> 
        <form:input path="quantity"  class="form-control"/></div> </div>
         <div class="form-group">
  
     <label class="col-md-4 control-label">Price </label><div class="input-group col-md-7"> 
        <form:input path="price"  class="form-control"/>
    </div> </div>
    <div class="form-group">
        
       <label class="col-md-4 control-label">Description</label><div class="input-group col-md-7"> 
        <form:input path="description"  class="form-control"/>
   </div> </div>
    <div class="form-group">
    <label class="col-md-4 control-label">File to upload:</label>
   <div class="input-group col-md-7"> 
	 <input type="file" name="file"  class="btn btn-default"  style="width:100%"/>
       </div>
       </div>
       <div class="row">
<div class="col-md-8 col-md-offset-5">
        <div class="form-group">
        <div class="input-group col-md-7">         
           <input type="submit" class="btn btn-danger" value="Submit"  style="width:50%"/>
            </div>  
            </div>
     </div>
     </div>
</form:form>

 
   </div>
</div>
</div>
</body>
</html>