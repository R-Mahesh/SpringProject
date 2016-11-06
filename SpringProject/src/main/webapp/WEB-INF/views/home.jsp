<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, intial-scale=1.0">

    
  </head>  
  <body>
   <div class="row">
  <div class="col-sm-3" >
<div class="list-group">
  <a href="#" class="list-group-item" style="background-color:white">  Make your choice   </a>
  <a href="first" class="list-group-item" >First item</a>
  <a href="second" class="list-group-item" >Second item</a>
<a href="third" class="list-group-item" >Third item</a>
<a href="fourth" class="list-group-item" >fourth item</a>
<a href="fifth" class="list-group-item" >fifth item</a>
<a href="sixth" class="list-group-item" >sixth item</a>
<a href="seventh" class="list-group-item" >seventh item</a>
<a href="eighth" class="list-group-item" >eighth item</a>
</div>
</div>
<div class="col-xs-9" >
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
    
     <a href="first"> <img src="<c:url value='/resources/images/img1.jpg'/>" alt="test"  class="img-responsive" alt="Chania" style="width:4000px;height:370px"/> </a>
    </div>

    <div class="item">
    <a href="second">  <img src="<c:url value='/resources/images/img2.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/></a>
    </div>

    <div class="item">
     <a href="third"> <img src="<c:url value='/resources/images/img3.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/></a>
    </div>

 
     <div class="item">
    <a href="fourth">  <img src="<c:url value='/resources/images/img4.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/></a>
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
<div class="container-fluid">
  <center><h1>Your special</h1></center>
  <div class="row">
    <div class="col-xs-6 col-sm-3" style="background-color:white;">
      <a href="#"><img src="<c:url value='/resources/images/img1.jpg'/>" alt="test" class="img-responsive"  style="width:4000px;height:370px"/></a>
    </div>
    <div class="col-xs-6 col-sm-3" style="background-color:white;"><img src="<c:url value='/resources/images/img3.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
    <!-- Add clearfix for only the required viewport -->
    
    <div class="col-xs-6 col-sm-3" style="background-color:white;"><img src="<c:url value='/resources/images/img2.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
   <div class="col-xs-6 col-sm-3" style="background-color:white;"><img src="<c:url value='/resources/images/img4.jpg'/>" alt="test" class="img-responsive" alt="Chania" style="width:4000px;height:370px"/>
    </div>
  </div>
</div>
  
  
  
<a href="register">Click here to resister</a>

</body>
</html>
