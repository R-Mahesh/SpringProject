<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
 
    
  </head>  
  <body>
  
   
   <div class="row">
  <div class="col-sm-3" >
<div class="list-group">
<c:if test="${!empty categoryList}">
<c:forEach items="${categoryList}" var="ctg">
  <a href="#" class="list-group-item" style="background-color:white">  Make your choice   </a>
  <a href="${ctg.sup1}" class="list-group-item" ><c:out value="${ctg.sup1}" /></a>
  <a href="${ctg.sup2}" class="list-group-item" ><c:out value="${ctg.sup2}" /></a>
<a href="${ctg.sup3}" class="list-group-item" ><c:out value="${ctg.sup3}" /></a>
<a href="${ctg.sup4}" class="list-group-item" ><c:out value="${ctg.sup4}" /></a>
<a href="${ctg.sup5}" class="list-group-item" ><c:out value="${ctg.sup5}" /></a>
<a href="${ctg.sup6}" class="list-group-item" ><c:out value="${ctg.sup6}" /></a>
<a href="${ctg.sup7}" class="list-group-item" ><c:out value="${ctg.sup7}" /></a>
<a href="${ctg.sup8}" class="list-group-item" ><c:out value="${ctg.sup8}" /></a>
 </c:forEach>
  </c:if>
</div>
</div>


<div class="col-xs-8" >
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  
  <div class="carousel-inner" role="listbox" >
    <div class="item active"  >
    
     <a href="first/WaterHeater"> <img src="<c:url value='/resources/images/rot2.jpeg'/>" alt="test"  class="img-responsive" alt="Chania" style="width:3000px;height:370px"/> </a>
    </div>

    <div class="item">
    <a href="second">  <img src="<c:url value='/resources/images/toster1.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:3000px;height:370px"/></a>
    </div>

    <div class="item">
     <a href="third"> <img src="<c:url value='/resources/images/ind3.jpeg'/>" alt="test" class="img-responsive" alt="Chania" style="width:3000px;height:370px"/></a>
    </div>

 
     <div class="item">
    <a href="fourth">  <img src="<c:url value='/resources/images/oven3.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:3000px;height:370px"/></a>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</div>
<%-- <div class="container-fluid">
  <center><h1>Your special</h1></center>
  <div class="row">
    <div class="col-xs-6 col-sm-3" style="background-color:white;">
      <a href="#"><img src="<c:url value='/resources/images/oven3.jpg'/>" alt="test" class="img-responsive"  style="width:4000px;height:370px"/></a>
    </div>
    <div class="col-xs-6 col-sm-3" style="background-color:white;"><img src="<c:url value='/resources/images/rot1.jpeg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
    <!-- Add clearfix for only the required viewport -->
    
    <div class="col-xs-6 col-sm-3" style="background-color:white;"><img src="<c:url value='/resources/images/toster1.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
   <div class="col-xs-3 " style="background-color:white;">
<img src="<c:url value='/resources/images/cokr1.jpeg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
  </div>
</div>
 --%> 

<a href="register" style="color:black">Click here to register</a>
<a href="user">Click here to login as User</a>
<!-- <a href="admin" style="color:Red">Click here to login as Admin</a> -->
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="Admin" style="color:green">Click here to edit options Admin</a>
</sec:authorize>
</body>
</html>
