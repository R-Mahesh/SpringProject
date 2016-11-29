<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta name="viewport" content="width=device-width, intial-scale=1.0">
     <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
 
    
 <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  p {
    word-spacing:1px;
}
h2
{color:red;}
  </style>
  
</head>
<title>
welcome
</title>
<body>
<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" style="color:blue"><i><b>HotElectronApplainces</b></i></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index" style="color:white"><b>Home</b></a></li>
      <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
      <li><a href="<c:url value="logout" />" style="color:white"><b>Logout</b></a></li>
      </sec:authorize>
      <li><a href="register" style="color:white"><b>Contact US</b></a></li>
     
   
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
      <li>
      <a class="active" class="btn btn-default btn-lg" id="myBtn" style="color:white"><span class="glyphicon glyphicon-user"><b>SignUp</b></span></a>
        

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
            <button type="button" class="close" data-dismiss="modal">&times;</button> 
          <h4><span class="glyphicon glyphicon-user"></span>Sign Up</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form:form role="form" action="addUser" name="myForm" method="POST" modelAttribute="user" onsubmit="return validateForm()">
            <div class="form-group" >
              <form:label path="name"><span class="glyphicon glyphicon-user"></span> Name</form:label>
              <form:input type="text" class="form-control" id="name" path="name" placeholder="Name" ></form:input>
           <form:errors path="name" cssClass="error" />
            </div>
             <div class="form-group">
              <form:label  path="password"><span class="glyphicon glyphicon-phone"></span> PhoneNumber</form:label>
              <form:input type="text" class="form-control"  path="password" placeholder="passWord"></form:input>
             </div>
               <button type="submit" class="btn btn-success btn-block" ><span class="glyphicon glyphicon-off"></span> Submit</button>
          <div class="modal-footer">
         <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          
        </div>
        
              </form:form>
           <%--  <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Email</label>
              <input type="email" class="form-control" ="e-mail" placeholder="Enter email">
            </div>
             <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> confirm Password</label>
              <input type="password" class="form-control" id="psw2" placeholder="Enter password Again">
            </div> --%> 
            
            
        </div>
       
      </div>
      
    </div>
  </div>
      </li>
      <li>
      
 
  <!-- Trigger the modal with a button -->
  <!-- href="user/logintosite" -->
<a class="active" class="btn btn-default btn-lg" id="myBtn2" style="color:white" ><span class="glyphicon glyphicon-log-in"><b> Login</b></span></a>
  <!-- Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
        
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <h2>${no}</h2>
          <form action="user" role="form" name="MyForm" onsubmit="return validateForm2()">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" name="name" id="usrname" placeholder="Enter name">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" name="password" id="psw" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox"  checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>NotAMember?<a href="#">SignUp</a></p>
        <!--    <p>Forgot<a href="#">Password?</a></p>-->
        </div>
      </div>
      
    </div>
  </div>
</li>
<li >
      <a style="color:white" class="glyphicon glyphicon-shopping-cart"><i><b>cart</b></i></a>
      
    </li>         
  
    </ul>
  </div> 
 
  
     <ul>
     <li>
        <form class="navbar-form" role="search" action="./search">
        <center>
         <input type="text" class="form-control" placeholder="Search" name="Search" style="width:60%">
            
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
           </center>
             
        </form>
        </li>
        <li >
      <a style="color:white"><i><b>View all products</b></i></a>
      
    </li>         
  
        </ul>
   
        
    </nav>
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

<script>
$(document).ready(function(){
    $("#myBtn2").click(function(){
        $("#myModal2").modal();
    });
}); 


</script>
<c:if test="${no == 'invalid entry'}">
<script type="text/javascript">
    $(window).load(function(){
        $('#myModal2').modal('show');
    });
</script>
</c:if> 

 


</body>
</html>