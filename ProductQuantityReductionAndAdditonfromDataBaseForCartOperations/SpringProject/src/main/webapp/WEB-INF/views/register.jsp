<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
    top:70%;
    left:50%;
    margin-left:-380px;
    margin-top:150px;
    z-index:60;
}
 </style>
 <style>
.modal-header, h4, .close {
	background-color: #5cb85c;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}

p {
	word-spacing: 1px;
}

h2 {
	color: red;
}
</style>
 
</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
<nav class="navbar navbar-inverse" >
	<div class="container-fluid" style="color: white">
		<div class="navbar-header">
			<a class="navbar-brand" style="color: white"><i><b>HotElectronApplainces</b></i></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="index" style="color: white"><b>Home</b></a></li>

			<li><a href="register" style="color: white"><b>Contact
						US</b></a></li>
			
		</ul>

		<ul class="nav navbar-nav navbar-right">



			<li><sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
					<a class="active" class="btn btn-default btn-lg"
						href="<c:url value="logout" />" style="color: white"><span
						class="glyphicon glyphicon-off"></span> <b> logout</b></a>
				</sec:authorize></li>

			<li><sec:authorize access="isAnonymous()"><a class="active" class="btn btn-default btn-lg"
				href="memberShip.obj" style="color: white"><span
					class="glyphicon glyphicon-user"><b>SignUp</b></span></a></sec:authorize></li>
			<li>
				<!-- Trigger the modal with a button --> <!-- href="login" --> <!-- href="user/logintosite" -->
				<sec:authorize access="isAnonymous()">
					<a class="active" class="btn btn-default btn-lg" id="myBtn2"
						href="login" style="color: white"><span
						class="glyphicon glyphicon-log-in"><b> Login</b></span></a>
				</sec:authorize> <!-- Modal -->
				<div class="modal fade" id="myModal2" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header" style="padding: 35px 50px;">

								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>
									<span class="glyphicon glyphicon-lock"></span> Login
								</h4>
							</div>
							<div class="modal-body" style="padding: 40px 50px;">
								<h2>${message}</h2>
								<form:form action="login" role="form" name="MyForm"
									modelAttribute="user" onsubmit="return validateForm2()">
									<div class="form-group">
										<form:label path="userName">
											<span class="glyphicon glyphicon-user"></span> Username</form:label>
										<form:input type="text" class="form-control" path="userName"
											id="userName" placeholder="Enter name" />
									</div>
									<div class="form-group">
										<form:label path="password">
											<span class="glyphicon glyphicon-eye-open"></span> Password</form:label>
										<form:input type="password" class="form-control"
											path="password" id="psw" placeholder="Enter password" />
									</div>
									<button type="submit" class="btn btn-success btn-block">
										<span class="glyphicon glyphicon-off"></span> Login
									</button>
								</form:form>
							</div>
							`
							<div class="modal-footer">
								<button type="submit"
									class="btn btn-danger btn-default pull-left"
									data-dismiss="modal">
									<span class="glyphicon glyphicon-remove"></span> Cancel
								</button>
								<p>
									NotAMember?<a href="memberShip.obj">SignUp</a>
								</p>
								<!--    <p>Forgot<a href="#">Password?</a></p>-->
							</div>
						</div>

					</div>
				</div>
			</li>
			<li><sec:authorize access="hasAnyRole('ROLE_USER')">
			
			
					<a href="cartItemDisplay"style="color: white" class="glyphicon glyphicon-shopping-cart"><i ><b style="color:red">${cNo}</b></i></a>
				 
				  
				 				</sec:authorize></li>

		</ul>
	</div>


	<ul>
		<li>
			<form class="navbar-form" action="category" method="get">
				<center>
			
					 <input list="search" class="form-control" name="id"
						style="width: 60%" >
						
					<datalist id="search">
					<c:if test="${!empty categoryList}">
						<c:forEach items="${categoryList}" var="ctg">
				<option value=	"${ctg.categoryName}">
					
					 </c:forEach>
  
  </c:if>
					</datalist>
					
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
 				</center>
			</form>
		</li>

	</ul>
<ul class="nav navbar-nav">
		<li><a href="productList" style="color: white"><i><b>View all products</b></i></a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="productsForm" style="color: white"><i><b>add products</b></i></a></li></sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="carousalNew" style="color: white"><i><b>insert new carousal images</b></i></a></li></sec:authorize>
		</ul>
	</nav>



	<c:if test="${no == 'notValid'}">
		<script type="text/javascript">
			$(window).load(function() {
				$('#myModal2').modal('show');
			});
		</script>
	</c:if>
	<c:if test="${pop}">
		<script type="text/javascript">
			$(window).load(function() {
				$('#myModal2').modal('show');
			});
		</script>
	</c:if>


   <div class="row">
<div class="col-md-6 col-md-offset-1" style=" position:absolute; top:10%;
    /* left:50%;
    margin-left:-420px; */
    margin-top:80px;
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
     <div class="form-group">
      <label class="col-md-4 control-label" style="color: white">MAIL-ID</label> 
      <!--  <div class="input-group col-md-7"> -->
   <form:input type="text" path="userEmail"  style="width:50%" class="form-control"/>
       <span style="color:red">
        <form:errors path="userEmail"  /></span>
         <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('userEmail')}" var="err">
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
