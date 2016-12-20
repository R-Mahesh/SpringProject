<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<script src="<c:url value="/resources/js/angular-1.4.8.min.js" />"></script>
<script>
angular.module('myApp', [])
.controller('MyController', ['$scope', '$http', function($scope, $http) {
	  
    $http.get("baba").success(function(data) { 
    	$scope.searchFish   = '';
      $scope.person=data;
      
    })
  ;

}]);

/* angular.module('sortApp', [])

.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // set the default sort type
  $scope.sortReverse  = false;  // set the default sort order
  $scope.searchFish   = '';     // set the default search/filter term
  
  // create the list of sushi rolls 
  $scope.sushi = [
    { name: 'Cali Roll', fish: 'Crab', tastiness: 2 },
    { name: 'Philly', fish: 'Tuna', tastiness: 4 },
    { name: 'Tiger', fish: 'Eel', tastiness: 7 },
    { name: 'Rainbow', fish: 'Variety', tastiness: 6 }
  ];
  
}); */    </script>

<body>

<!--  <div class="container" ng-app="sortApp" ng-controller="mainController">  
  <div class="alert alert-info">
    <p>Sort Type: {{ sortType }}</p>
    <p>Sort Reverse: {{ sortReverse }}</p>
    <p>Search Query: {{ searchFish }}</p>
  </div>
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>

        <input type="text" class="form-control" placeholder="Search da Fish" ng-model="searchFish">

      </div>      
    </div>
  </form>
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
 <td>
      <a href="#" ng-click="sortType = 'name'; sortReverse = !sortReverse">
        Sushi Roll 
        <span ng-show="sortType == 'name' && !sortReverse" class="fa fa-caret-down"></span>
        <span ng-show="sortType == 'name' && sortReverse" class="fa fa-caret-up"></span>
      </a>
    </td>
        <td>
          <a href="#" ng-click="sortType = 'fish'">
          <span ng-show="sortType == 'fish'" class="fa fa-caret-down"></span>
          Fish Type 
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'tastiness'">
          <span ng-show="sortType == 'tastiness'" class="fa fa-caret-down"></span>
          Taste Level 
          </a>
        </td>
      </tr>
      
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in sushi | orderBy:sortType:sortReverse | filter:searchFish ">
        <td>{{ roll.name }}</td>
        <td>{{ roll.fish }}</td>
        <td>{{ roll.tastiness }}</td>
      </tr>
    </tbody>
    
  </table>
 </div> -->
    <div class="container" ng-app="myApp" ng-controller="MyController">
       <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>

        <input type="text" class="form-control" placeholder="Search da Fish" ng-model="searchFish">

      </div>      
    </div>
  </form>
    
           <div ng-repeat="roll in person | filter:searchFish ">
                      
           <p>First Name : {{roll.name}}</p>
           </div>
                   
      </div>
  

</body>
</html>
