<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:if test="${!empty productList}">
  
<div class="row text-center">
 <c:forEach items="${productList}" var="ctg">
 <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <a href="#"><img src="<c:url value='/resources/images/${ctg.name}.jpg'/>" alt="test" class="img-responsive"  style="width:4000px;height:370px"/></a>
          <p><strong>New York</strong></p>
          <p>Saturday 28 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
      </c:forEach>
    <!--   <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
       <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
       <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
      <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
      <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
      <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div>
      <div class="col-xs-6 col-sm-3">
        <div class="thumbnail">
          <img src="sanfran.jpg" alt="San Francisco" style="width:4000px;height:370px" >
          <p><strong>San Francisco</strong></p>
          <p>Sunday 29 November 2015</p>
          <button class="btn" toggle="modal" target="#myModal">Buy now</button>
        </div>
      </div> -->
     
   </div>
    
    </c:if>
</body>
</html>