<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>

</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
<c:if test="${!empty prdLst}">
  <c:forEach items="${prdLst}" var="product">
  	<div class="col-xs-6 col-sm-3">
  	
					<div class="thumbnail">
   <img src="<c:url value='/resources/images/${product.name}.jpg'/>" class="img-responsive" alt="RotiMaker" style="width:80px;height:80px"/>${product.name}
  </div>
  
  </div>
   </c:forEach>
  </c:if>
  
  
  <div class="row">
<div class="col-md-6 col-md-offset-3">
<div class="jumbotron" style="width:500px;height:400px"> 
 <form:form  modelAttribute="carousal" method="POST" action="./addToCarousal">
    
     <div class="form-group">
     <label class="col-md-4 control-label">product1</label>
     <div class="input-group col-md-7"> 
        <form:input path="product1" name="name" class="form-control"/>
          <form:errors path="product1" cssClass="error" />
          </div> </div>
           <div class="form-group">
    
      <label class="col-md-4 control-label">product2</label><div class="input-group col-md-7"> 
        <form:input path="product2"  class="form-control"/></div> </div>
         <div class="form-group">
  
     <label class="col-md-4 control-label">product3 </label><div class="input-group col-md-7"> 
        <form:input path="product3"  class="form-control"/>
    </div> </div>
    <div class="form-group">
        
       <label class="col-md-4 control-label">product4</label><div class="input-group col-md-7"> 
        <form:input path="product4"  class="form-control"/>
   </div> </div>
      <%--  <div class="form-group">
   <label class="col-md-4 control-label">product4</label><div class="input-group col-md-7"> 
        <form:input path="product4"  class="form-control"/>
   </div> </div>
       <div class="form-group">
    <label class="col-md-4 control-label">product</label><div class="input-group col-md-7"> 
        <form:input path="product"  class="form-control"/>
   </div> </div>
       <div class="form-group">
    <label class="col-md-4 control-label">product</label><div class="input-group col-md-7"> 
        <form:input path="product"  class="form-control"/>
   </div> </div>
       <div class="form-group">
    <label class="col-md-4 control-label">product</label><div class="input-group col-md-7"> 
        <form:input path="product"  class="form-control"/>
   </div> </div> --%>
   
  
  
  
       <div class="row">
<div class="col-md-8 col-md-offset-5">
        <div class="form-group">
        <div class="input-group col-md-7">         
           <input type="submit" class="btn btn-danger" value="Submit"  style="width:50%" />
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