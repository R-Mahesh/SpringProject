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
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
<center>

 <div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3" style=" position:absolute; top:30%;
     left:50%;
    margin-left:-420px; 
    margin-top:100px;
    z-index:60;">
 


 
<div style="color: teal; font-size: 30px">
   Edit Details</div>
 


  <form:form  modelAttribute="products" method="post"
   action="updateProduct" enctype="multipart/form-data">
   <table width="400px" height="150px">
   <div class="form-group">
        <form:hidden path="id"  value="${productDetail.id}" class="form-control"  style="width:50%"/>
        </div>
   
     
      <div class="form-group">
			 <label class="col-md-4 control-label" style="color: white"> Select Category</label>
					 <form:input list="search" class="form-control" name="id" path="category" value="${productDetail.category}"
						style="width:50%" />
						
					<datalist id="search">
					<c:if test="${!empty categoryList}">
						<c:forEach items="${categoryList}" var="ctg">
				<option value=	"${ctg.categoryName}">
					
					 </c:forEach>
  
  </c:if>
					</datalist>
					</div>
     <div class="form-group">
        
       <label class="col-md-4 control-label" style="color: white">quantity</label><!-- <div class="input-group col-md-7"> --> 
        <form:input path="quantity" value="${productDetail.quantity}" class="form-control" style="width:50%"/>
 </div>  
    <div class="form-group">
        
       <label class="col-md-4 control-label" style="color: white">price</label><!-- <div class="input-group col-md-7"> --> 
        <form:input path="price" value="${productDetail.price}" class="form-control" style="width:50%"/>
 </div>
    
     <div class="form-group">
        
       <label class="col-md-4 control-label" style="color: white">description</label><!-- <div class="input-group col-md-7"> --> 
        <form:input path="description" value="${productDetail.description}" class="form-control" style="width:50%"/>
 </div>
  <div class="form-group">
        
       <label class="col-md-4 control-label" style="color: white">name</label><!-- <div class="input-group col-md-7"> --> 
        <form:input path="name" value="${productDetail.name}" class="form-control" style="width:50%"/>
 </div>
   <div class="form-group">
    <label class="col-md-4 control-label" style="color: white">File to upload:</label>
	 <input type="file" name="file" class="btn btn-default"  style="width:50%"/>
    <form:errors path="name" cssClass="error" />
       </div>
      <div class="row">
<div class="col-md-8 col-md-offset-5">
        <div class="form-group">
           <input type="submit" class="btn btn-danger" value="Update"  style="width:50%" />
           </div>
     </div>
     </div>
     </div>
     </div>
  </form:form>

  
 </center>
</body>
</html>