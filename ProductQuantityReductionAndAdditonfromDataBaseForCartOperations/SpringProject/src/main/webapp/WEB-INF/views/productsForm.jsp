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
<body background="<c:url value='/resources/images/u5c8E.gif'/>" >
<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3" style=" position:absolute; top:90%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:100px;
    z-index:60;">
<!-- <div class="jumbotron" style="width:500px;height:400px">  -->
 <form:form  modelAttribute="products" method="POST" action="./addProducts" enctype="multipart/form-data">
   
   
  
   
    
     <div class="form-group">
			 <label class="col-md-4 control-label" style="color: white"> Select Category</label>
 <!--   <div class="input-group col-md-7">    --> 
					 <form:input list="search" class="form-control" name="id" path="category"
						style="width:50%" />
						
					<datalist id="search">
					<c:if test="${!empty categoryList}">
						<c:forEach items="${categoryList}" var="ctg">
				<option value=	"${ctg.categoryName}">
					
					 </c:forEach>
  
  </c:if>
					</datalist>
					<!-- </div> -->
					</div>
     <div class="form-group">
     <label class="col-md-4 control-label" style="color: white">Name</label>
   <!--   <div class="input-group col-md-7">  -->
        <form:input path="name" name="name" class="form-control"  style="width:50%"/>
          <form:errors path="name" cssClass="error" />
         <!--  </div> --> </div>
           <div class="form-group">
    
      <label class="col-md-4 control-label" style="color: white">Quantity</label><!-- <div class="input-group col-md-7">  -->
        <form:input path="quantity"  class="form-control" style="width:50%"/><!-- </div> --> </div>
         <div class="form-group">
  
     <label class="col-md-4 control-label" style="color: white">Price </label><!-- <div class="input-group col-md-7">  -->
        <form:input path="price"  class="form-control" style="width:50%"/>
   <!--  </div> --> </div>
    <div class="form-group">
        
       <label class="col-md-4 control-label" style="color: white">Description</label><!-- <div class="input-group col-md-7"> --> 
        <form:input path="description"  class="form-control" style="width:50%"/>
  <!--  </div> --> </div>
    <div class="form-group">
    <label class="col-md-4 control-label" style="color: white">File to upload:</label>
  <!--  <div class="input-group col-md-7">  -->
	 <input type="file" name="file"  class="btn btn-default"  style="width:50%"/>
      <!--  </div> -->
       </div>
       <div class="row">
<div class="col-md-8 col-md-offset-5">
        <div class="form-group">
       <!--  <div class="input-group col-md-7">    -->      
           <input type="submit" class="btn btn-danger" value="Submit"  style="width:50%" />
           <!--  </div>   -->
            <!-- </div> -->
     </div>
     </div>
</form:form>


   </div>
</div>
</div>
</div>
</body>
</html>