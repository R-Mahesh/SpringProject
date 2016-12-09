<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	 <form:form  modelAttribute="user" action="addUser" method="POST" ><%-- action="addUser" --%>
   
<%-- <!--     <tr> -->
     <td><form:label path="id">id</form:label></td>
        <td><form:input path="id" /></td>
<!--     </tr> --> --%>
<div class="form-group">
    
    <form:label path="name" >Name</form:label>
    
        <form:input path="name" class="form-control" name="name"/>
        <form:errors path="name"/>
    </div>
    <div class="form-group">
       <form:label path="password">password</form:label>
        <form:input type="password" path="password"  name="password" class="form-control"/>
        <form:errors path="password"  />
    
    </div>
      <div class="form-group"> 
           <!--  <input type="submit"  value="Add"/> -->
          <input  type="submit" value="Submit" class="form-control"/> 
      </div>  
   


</form:form> 
<%--  <c:url value='j_spring_security_check' />   --%>
	<div ng-app="myApp" ng-controller="namesCtrl">

<p>Type a letter in the input field:</p>

<p><input type="text" ng-model="test"></p>

<ul>
  <li ng-repeat="x in names | filter:test">
    {{ x }}
  </li>
</ul>

</div>

<script>
angular.module('myApp', []).controller('namesCtrl', function($scope) {
    $scope.names = [
        'Jani',
        'Carl',
        'Margareth',
        'Hege',
        'Joe',
        'Gustav',
        'Birgit',
        'Mary',
        'Kai'
    ];
});
</script>

<p>The list will only consists of names matching the filter.</p>


</body>
</html>