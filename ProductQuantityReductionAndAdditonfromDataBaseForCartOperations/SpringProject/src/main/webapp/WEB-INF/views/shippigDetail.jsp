<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
 
</head>
<body>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
   <div class="row">
<div class="col-md-6 col-md-offset-1" style=" position:absolute; top:10%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:60px;
    z-index:60;">
<a href="${flowExecutionUrl}&_eventId_home">Home</a>
	 <form:form  modelAttribute="shipmentDetail">
	 <div class="form-group">
     <label class="col-md-4 control-label" style="color: white" >Name</label> <form:input path="name"  class="form-control"  style="width:50%" />
        <span style="color:red">    <form:errors path="name"/></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       </div>
     <div class="form-group">
     <label class="col-md-4 control-label" style="color: white" >phoneNumber</label> <form:input path="phoneNumber"  class="form-control"  style="width:50%" />
        <span style="color:red">    <form:errors path="phoneNumber"/></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('phoneNumber')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       </div>
     <div class="form-group">
     <label class="col-md-4 control-label" style="color: white" >address</label> <form:input path="address"  class="form-control"  style="width:50%" />
        <span style="color:red">    <form:errors path="address"/></span>
        <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('address')}" var="err">
				  <div><span style="color:red">${err.text}</span></div>
				  </c:forEach><br />
       </div>
         <div class="row">
<div class="col-md-6 col-md-offset-4">
 <div   class="form-group">
           <!--  <input type="submit"  value="Add"/> -->
           
         <input name="_eventId_submit" type="submit" value="Submit" class="btn btn-danger" style="width:200px"/>
        </div>
        </div>
     </div>
       
    </form:form>
    </div>
    </div>
</body>
</html>