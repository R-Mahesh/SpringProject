<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
 
    
  </head>  
  <body background="<c:url value='/resources/images/u5c8E.gif'/>">
   
   <div class="row">
  <div class="col-sm-3" >
<div class="list-group" >
<a class="list-group-item" style="background-color:black" style="height:50px"> <b style="color: white"> Make your choice </b>  </a>
<c:if test="${!empty categoryList}">

<c:forEach items="${categoryList}" var="ctg">

    <a href="category?id=${ctg.categoryName}" class="list-group-item" style="height:45px"><c:out value="${ctg.categoryName}" /></a>
   

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
  
     <a href="search?Details=${carousalList.product1}"><img src="<c:url value='/resources/images/${carousalProduct.product1}.jpg'/>"   class="img-responsive" alt="RotiMaker" style="width:3000px;height:400px"/> </a>
  
    </div>
   
    

    <div class="item">
    <a href="search?Details=${carousalList.product2}">  <img src="<c:url value='/resources/images/${carousalProduct.product2}.jpg'/>"  class="img-responsive" alt="Toaster" style="width:3000px;height:400px"/></a>
    </div>

    <div class="item">
     <a href="search?Details=${productDetail.product3}"> <img src="<c:url value='/resources/images/${carousalProduct.product3}.jpg'/>" class="img-responsive" alt="InductionStove" style="width:3000px;height:400px"/></a>
    </div>

 
     <div class="item">
    <a href="search?Details=${carousalList.product4}">  <img src="<c:url value='/resources/images/${carousalProduct.product4}.jpg'/>"  class="img-responsive" alt="ElectricOven" style="width:3000px;height:400px"/></a>
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


<fieldset>
	</fieldset>
</body>
</html>
