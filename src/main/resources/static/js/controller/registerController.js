var app = angular.module('myApp');

app.controller('registerController', function($scope, $routeParams) {

	$scope.AddUser = function(){
		$scope.user = {
			name:$scope.name, 
			username:$scope.username, 
			password:$scope.password,
			gender:$scope.gender,
			birthday:$scope.birthday,
			email:$scope.email,
			address:$scope.address,
			job:$scope.job,
		};
			$http.post("http://localhost:9000/LMS/userInfo/add",$scope.user)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){});
		
	}
	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/userInfo/list"
		}).success(function(data, status, headers, config){
			$scope.user = data;
		})
		.error(function(data, status, headers, config){});
	}
});