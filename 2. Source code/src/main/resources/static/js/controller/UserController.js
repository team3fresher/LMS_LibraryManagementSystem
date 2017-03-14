var app = angular.module('myAdmin');
app.controller("UserController", function($scope, $http){
		
	$scope.AddUser = function(){
		$scope.user = {
			"address": $scope.user.address,
			"degree": $scope.user.degree,	
			"email": $scope.user.email,
			"job": $scope.user.job,
			"phoneNumber": $scope.user.phone,
			"pword": "test",
			"realName": $scope.user.name,
			"sex": "male",
			"valid": "true",
			"dayOfBirth":$scope.user.day,
		};
			$http.post("http://localhost:9000/LMS/userInfo/add",$scope.user)
			.success(function(data, status, headers, config){
				//alert("Add user success!!");
				
			})
			.error(function(data, status, headers, config){
				//alert("Add user error!!");

			});
		
	}
	$scope.removeUser = function(x){
		//$scope.users.splice(x, 1);
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/userInfo/remove/"+x
		}).success(function(data, status, headers, config){
			$scope.users = data;
			getData();
		})
		.error(function(data, status, headers, config){
			getData();
		});
		
	}
	$scope.orderByMe = function(x){
		$scope.myOrderBy = x;
	}


	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/userInfo/list"
		}).success(function(data, status, headers, config){
			$scope.users = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	
})