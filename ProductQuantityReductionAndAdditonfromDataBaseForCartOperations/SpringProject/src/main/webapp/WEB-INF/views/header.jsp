<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<!-- <link rel="shortcut icon" href="/resources/images/google-plus-download.jpg" type="image/jpg"> -->
<!-- img src='/resources/images/google-plus-download.jpg' -->
<title> 

NEW</title>
<style>
#circle{
width:1 px;
height:1 px;


border-radius: .5px;
background:red;
}</style>

   <meta name="viewport" content="width=device-width, intial-scale=1.0">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


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
<body>
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

<li><sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"><a class="active" style="color: white"><span style="color: red">WELCOME</span>${UserName}</a></sec:authorize></li>

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
						><b>Login</b></span></a><!-- class="glyphicon glyphicon-log-in" -->
				</sec:authorize> <!-- Modal -->
				<div class="modal fade" id="myModal2" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header" style="padding: 35px 50px;">

								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>
									<span class="glyphicon glyphicon-lock">Login</span>
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
					 <button class="btn btn-default" type="submit" style="height:05.2%" >
						<i class="glyphicon glyphicon-search"></i>
					</button>
					
 				</center>
			</form>
		</li>

	</ul>
<ul class="nav navbar-nav">
		<li><a href="productList" style="color: white"><i><b>View all products</b></i></a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="productsForm" style="color: white"><i><b>add products</b></i></a></li></sec:authorize>
		<%-- <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="carousalNew" style="color: white"><i><b>insert new carousal images</b></i></a></li></sec:authorize> --%>
		<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="categorylist" style="color: white"><i><b>edit category list</b></i></a></li></sec:authorize>
		</ul>
	</nav>


<sec:authorize access="isAnonymous()">
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
</sec:authorize>
</body>
</html>
