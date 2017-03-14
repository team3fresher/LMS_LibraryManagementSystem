var app = angular.module('myAdmin');
app.controller("userDetailCtr", function($scope, $http, $routeParams){
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/userInfo/get/"+$routeParams.id
	}).success(function(data) {
		$scope.address=data.address;
		$scope.degress=data.degress;	
		$scope.email=data.email;
		$scope.job=data.job;
		$scope.phone=data.phoneNumber;
		$scope.name=data.realName;
		$scope.gender=data.sex;
	})
	$scope.EditUser=  function(){
		$scope.gender="";
	}
})