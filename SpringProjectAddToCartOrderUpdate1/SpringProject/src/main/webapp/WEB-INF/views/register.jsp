<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Form Handling</title>
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
 <style>
 .jumbotron{
    position:absolute;
    top:50%;
    left:50%;
    margin-left:-380px;
    margin-top:100px;
    z-index:60;
}
 </style>
</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
   <div class="row">
<div class="col-md-6 col-md-offset-1" style=" position:absolute; top:10%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:60px;
    z-index:60;">

<!--   <div class="jumbotron" style="width:500px;height:500px">  -->
  <div class="container">
  <a href="${flowExecutionUrl}&_eventId_home">Home</a>
<fieldset>
        <div class="col-md-6 col-md-offset-4">
         <h3 style="color: white"><span class="glyphicon glyphicon-pencil" style="color: white"></span style="color: white">  SignUp</h3>
         </div>
	 <form:form  modelAttribute="user"> <!-- action="addUser" -->
     <div class="form-group">
   <!-- style="width:370px" -->
     <label class="col-md-4 control-label" style="color: white" >Name</label> <!--  <div class="input-group col-md-7" > --><form:input path="userName"  class="form-control"  style="width:50%" />
        <span style="color:red">    <form:errors path="userName"/></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('userName')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       <%--  <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err"> --%>
					 <%--  <div><span style="color:red">${err.text}</span></div> --%>
					<%-- </c:forEach> --%>
				<!-- 	</div> -->
    </div>
     <div class="form-group">
      <label class="col-md-4 control-label" style="color: white">password</label> 
       <!-- <div class="input-group col-md-7"> -->
   <form:input type="password" path="password"  style="width:50%" class="form-control"/>
        <span style="color:red">    <form:errors path="password"  /></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
        <%-- <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span  style="color:red">${err.text}</span></div>
					</c:forEach>
     --%>
  <!--   </div> -->
    </div>
     <div class="form-group">
      <label class="col-md-4 control-label" style="color: white">ConfirmPassWord</label> 
      <!--  <div class="input-group col-md-7"> -->
   <form:input type="password" path="confirmPassWord"  style="width:50%" class="form-control"/>
       <span style="color:red">
        <form:errors path="confirmPassWord"  /></span>
         <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('confirmPassWord')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       
        <%-- <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('confirmPassWord')}" var="err">
					  <div><span style="color:red">${err.text}</span></div>
					</c:forEach> --%>
   
   <!--  </div> -->
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

</fieldset> 
</div> <!-- </div> --> 

</div>
</div>

</body>
</html>
