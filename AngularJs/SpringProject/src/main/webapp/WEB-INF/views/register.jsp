<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Form Handling</title>
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
 
</head>
<body>
   <div class="row">
<div class="col-md-6 col-md-offset-4">

  <div class="jumbotron" style="width:500px;height:450px"> 
  <div class="container">
<fieldset>
        <div class="col-md-6 col-md-offset-4">
         <h3><span class="glyphicon glyphicon-pencil"></span> SignUp</h3>
         </div>
	 <form:form  modelAttribute="user"> <!-- action="addUser" -->
     <div class="form-group">
   <!-- style="width:370px" -->
     <label class="col-md-4 control-label" >Name</label>  <div class="input-group col-md-7" ><form:input path="userName"  class="form-control" />
        <span style="color:red">    <form:errors path="userName"/></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('userName')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       <%--  <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err"> --%>
					 <%--  <div><span style="color:red">${err.text}</span></div> --%>
					<%-- </c:forEach> --%>
					</div>
    </div>
     <div class="form-group">
      <label class="col-md-4 control-label">password</label> 
       <div class="input-group col-md-7">
   <form:input type="password" path="password"   class="form-control"/>
        <span style="color:red">    <form:errors path="password"  /></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
        <%-- <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span  style="color:red">${err.text}</span></div>
					</c:forEach>
     --%>
    </div>
    </div>
     <div class="form-group">
      <label class="col-md-4 control-label">ConfirmPassWord</label> 
       <div class="input-group col-md-7">
   <form:input type="password" path="confirmPassWord"  class="form-control"/>
       <span style="color:red">
        <form:errors path="confirmPassWord"  /></span>
         <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('confirmPassWord')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       
        <%-- <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('confirmPassWord')}" var="err">
					  <div><span style="color:red">${err.text}</span></div>
					</c:forEach> --%>
   
    </div>
    </div>
<span style="color:red"> ${mismatch}</span>
       <div class="row">
<div class="col-md-6 col-md-offset-4">
 <div   class="form-group">
           <!--  <input type="submit"  value="Add"/> -->
           
         <input name="_eventId_submit" type="submit" value="Submit" class="btn btn-danger" style="width:200px"/>
        </div>
        </div>
        
  <!--  name="_eventId_submit" -->
</div>

</form:form> 
<a href="${flowExecutionUrl}&_eventId_home">Home</a>
</fieldset> 
</div> </div> 

</div>
</div>

</body>
</html>
