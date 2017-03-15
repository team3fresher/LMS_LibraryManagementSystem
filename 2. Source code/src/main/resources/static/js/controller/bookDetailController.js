var app = angular.module('myApp');

app.controller('bookDetailController', function($scope,$http, $routeParams) {
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/book/get/"+$routeParams.id
	}).success(function(data) {
		$scope.book.isbn=data.isbn,
		$scope.book.amount=data.amount,
		$scope.book.brwTcktNber=data.brwTcktNber,
		$scope.book.importance=data.importance,
		$scope.book.publishingYear=data.publishingYear,
		$scope.book.shortDescription=data.shortDescription,
		$scope.book.title=data.title,
		$scope.book.validStatus=data.validStatus
	})

});