var app = angular.module('myApp');

app.controller('MainController', function($scope, $http, $routeParams, productService, $rootScope) {
	$scope.myInterval = 3000;	 
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

app.service('productService', function() {
	  var productList = [];

	  var addProduct = function(newObj) {
	      productList.push(newObj);
	  };

	  var getProducts = function(){
	      return productList;
	  };

	  return {
	    addProduct: addProduct,
	    getProducts: getProducts
	  };

	});