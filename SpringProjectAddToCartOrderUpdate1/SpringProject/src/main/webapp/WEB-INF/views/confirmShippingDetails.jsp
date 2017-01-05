<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script><title>Insert title here</title>

</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
<div class="row" style=" position:absolute; top:10%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:60px;
    z-index:60;">
    <a href="${flowExecutionUrl}&_eventId_home">Home</a>
<div class="col-md-6 col-md-offset-3">

 <!--  <div class="jumbotron" style="width:500px;height:450px">  -->
  <div class="container">
			 <div class="col-md-6 col-md-offset-2">
         <h3 style="color: white"><span class="glyphicon glyphicon-pencil"></span> Confirm Details</h3>
         </div>
	
				
				
				
				<form:form modelAttribute="shipmentDetail">
				<div class="form-group">
				  <div class="input-group col-md-12" >
				  <label class="col-md-3 control-label" style="color: white">Name</label>
				<span style="color:red">${shipmentDetail.name}<form:hidden path="name"	value="${shipmentDetail.name}"/></span>
					<br /><br />
									</div>
    </div>
    			<div class="form-group">
				  <div class="input-group col-md-12" >
					<label class="col-md-3 control-label" style="color: white">phoneNumber</label>
				<span style="color:red">${shipmentDetail.phoneNumber}<form:hidden	path="phoneNumber"	value="${shipmentDetail.phoneNumber}"/></span>
					<br /><br />
					</div>
    </div>
    	<div class="form-group">
				  <div class="input-group col-md-12" > 
			 <label  class="col-md-3 control-label" style="color: white">address</label> 
				<span style="color:red">${shipmentDetail.address}<form:hidden  path="address" value="${shipmentDetail.address}"/></span>
					<br /><br />
						 </div>
    </div> 
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					      <div class="row">
<div class="col-md-4 col-md-offset-3">
 <div   class="form-group">
 
					<input name="_eventId_edit" type="submit" value="Edit" class="btn btn-danger" /> 
					<input name="_eventId_submit" type="submit"  value="Confirm Details" class="btn btn-default" onclick="myFunction()"/><br />
					 </div>
        </div>
        
</div>
				</form:form>
				</div>
	<!-- </div> -->
	</div>
	</div>
<script>
function myFunction() 
{
	alert("you are successfully registered")
	}</script>
</body></html>