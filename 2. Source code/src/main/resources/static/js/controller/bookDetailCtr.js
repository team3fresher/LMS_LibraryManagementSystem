var app = angular.module('myAdmin');
app.controller("bookDetailCtr", function($scope, $http, $routeParams){
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/book/get/"+$routeParams.id
	}).success(function(data) {
		$scope.isbn=data.isbn;
		$scope.amount=data.amount;
		$scope.brwTcktNber=data.brwTcktNber;
		$scope.importance=data.importance;
		$scope.publishingYear=data.publishingYear;
	    $scope.shortDescription=data.shortDescription;
	    $scope.title=data.title;
	    $scope.validStatus=data.validStatus;
	    $scope.authorDetails=data.authorDetails;
		$scope.bookCategoryDetail=data.bookCategoryDetail;
		$scope.publisherDetail=data.publisherDetail;
		$scope.ticketBookUsers=data.ticketBookUsers;
	})
	$scope.EditUser=  function(){
		$scope.gender="";
	}
})