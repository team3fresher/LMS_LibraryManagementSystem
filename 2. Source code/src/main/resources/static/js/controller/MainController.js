var app = angular.module('myApp');

app.controller('MainController', function($scope, $http, $routeParams, productService,userService, $rootScope) {
	$scope.myInterval = 3000;	 
	getData();
	$scope.searchText="";
	userService.update();
	$scope.status=userService.getUser();
	if(typeof($scope.status.status)=="undefined"){
		$scope.value=false;
	}
	else {
		$scope.value=true;
	}
	console.log($scope.status.status)
	getBookCategory1();
	getBookCategory2();
	getBookCategory3();
	getBookCategory4();
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	function getBookCategory1() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/get/"+2
		}).success(function(data){
			$scope.categoryBook1 = data;
		})
	}
	function getBookCategory2() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/get/"+12
		}).success(function(data){
			$scope.categoryBook2 = data;
		})
	}
	function getBookCategory3() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/get/"+7
		}).success(function(data){
			$scope.categoryBook3 = data;
		})
	}
	function getBookCategory4() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/get/"+6
		}).success(function(data){
			$scope.categoryBook4 = data;
		})
	}
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
				importance:y
		}
		productService.addProduct(newObj);
	}
});
