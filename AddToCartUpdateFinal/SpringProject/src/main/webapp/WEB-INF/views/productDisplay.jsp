  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	 
	

 	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
 

<head>
<style>



</style>

    <script src="<c:url value="/resources/js/angular-1.4.8.min.js" />"></script> 
  <script>
angular.module('myApp', [])
.controller('MyController', ['$scope', '$http', function($scope, $http) {
    $http.get("productLt").success(function(data) { 
      $scope.person=data;
      
    })
  ;

}]);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>new</title>
</head>
<body background="<c:url value='/resources/images/u5c8E.gif'/>">
	
<div class="container" ng-app="myApp" ng-controller="MyController">
          <div class="row">
<div class="col-md-10 col-md-offset-2">   
               <form>
    <div class="form-group">
      <div class="input-group">
    
        <div class="input-group-addon"><i class="fa fa-search">QUICK SEARCH</i></div>
     <input type="text" class="form-control" placeholder="search your wish" ng-model="searchFish" style="width:70%">
      </div> 
    </div>
  </form>
 </div>
 </div>
	<%-- <c:if test="${!empty productList}"> --%>

		<div class="row text-center">
			 <div ng-repeat="roll in person | filter:searchFish ">
				<div class="col-xs-6 col-sm-3">
					<div class="thumbnail">
						<a href="#"><img
							src="<c:url value='/resources/images/{{roll.name}}.jpg'/>"
							alt="test" class="img-responsive"
							style="width: 4000px; height: 370px" /></a>
						<p>
							&#x20B9<strong>{{roll.price}}</strong>
						</p>
						<p>{{roll.description}}</p>{{roll.id}}
						<sec:authorize access="hasRole('ROLE_USER')">
						<a href="details?id={{roll.id}}"><button class="btn">Buy Now</button></a>
						</sec:authorize>
						
						
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="editProduct?id={{roll.id}}"><button class="btn">Edit</button></a>
							<a href="deleteProduct?id={{roll.id}}"><button class="btn">Delete</button></a>
						</sec:authorize>
					</div>
				</div>

</div>
		</div>
		</div>
		
		
</body>
</html>
