var app = angular.module('myAdmin');
app.controller("userDetailCtr", function($scope, $http, $routeParams){
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/userInfo/get/"+$routeParams.id
	}).success(function(data) {
		$scope.iduser=data.userId;
		$scope.address=data.address;
		$scope.degree=data.degree;	
		$scope.email=data.email;
		$scope.job=data.job;
		$scope.phone=data.phoneNumber;
		$scope.password=data.pword;
		$scope.name=data.realName;
		$scope.gender=data.sex;
		$scope.day=data.dayOfBirth
	})
	$scope.EditUser=  function(){
		$scope.temp={
				"userId": $scope.iduser,
				"address": $scope.address,
				"degree": $scope.degree,
				"email": $scope.email,
				"job": $scope.job,
				"phoneNumber": $scope.phone,
				"pword": $scope.password,
				"realName": $scope.name,
				"sex": $scope.gender,
				"valid": true,
				"dayOfBirth": $scope.day
		}
		console.log($scope.temp)
		$http({
			method: 'post',
			url: "http://localhost:9000/LMS/userInfo/edit/"+$scope.temp
		}).success(function(data) {})
	}
})