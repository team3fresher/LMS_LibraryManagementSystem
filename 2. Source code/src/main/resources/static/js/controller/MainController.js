var app = angular.module('myApp');

app.controller('MainController', function($scope, $http, $routeParams, productService) {
	getData();
	$scope.searchText="";
	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/book/list"
		}).success(function(data, status, headers, config){
			$scope.books = data;

		})
		.error(function(data, status, headers, config){});
	}

	$scope.addCart= function (x)
	{
		var newObj ={
				id:x,
				valuable:1
		}
		productService.addProduct(newObj);
	}
});
