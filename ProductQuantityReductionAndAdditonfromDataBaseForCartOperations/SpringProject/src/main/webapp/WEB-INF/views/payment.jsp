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
   <h2> <a href="${flowExecutionUrl}&_eventId_home" style="color: white">Home</a></h2>
<div class="col-md-6 col-md-offset-3">

 <!--  <div class="jumbotron" style="width:500px;height:450px">  -->
  <div class="container">
			 <div class="col-md-6 col-md-offset-2">
			 
			 
			 
         <h3 style="color: white">Payment Mode</h3>
         
         <div>
<input type="radio" name="radio" id="radio1" class="radio" checked/>
<label for="radio1" style="color: red">credit Card/debit card</label>
</div>

<div>
<input type="radio" name="radio" id="radio2" class="radio"/>
<label for="radio2" style="color: red">paytm</label>
</div>

<div>	
<input type="radio" name="radio" id="radio3" class="radio"/>
<label for="radio3" style="color: red">cashOnDelivery</label>
</div>
         
         </div>
	
				
								
				
				<form:form modelAttribute="shipmentDetail">
				<div class="form-group">
				<form:hidden path="name"	value="${shipmentDetail.name}"/>
					<br /><br />
									</div>
    			<div class="form-group">
				<form:hidden	path="phoneNumber"	value="${shipmentDetail.phoneNumber}"/>
					<br /><br />
					</div>
    	<div class="form-group">
			<form:hidden  path="address" value="${shipmentDetail.address}"/>
					<br /><br />
						 </div>
								      <div class="row">
<div class="col-md-4 col-md-offset-3">
 <div   class="form-group">
 
					<input name="_eventId_submit" type="submit"  value="Confirm Details" class="btn btn-default" onclick="myFunction()"/><br />
					 </div>
        </div>
        
</div>
				</form:form>
				</div>
				
	</div>
	</div>
<script>
function myFunction() 
{
	alert("you are successfully placed your order and check your mail for our acknowledgement")
	}</script>
</body></html>