var app = angular.module('myAdmin');
app.controller("UserController", function($scope, $http){
		
	$scope.AddUser = function(){
		$scope.user = {
			
		};
			$http.post("http://localhost:9000/LMS/userInfo/add",$scope.book)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){});
		
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