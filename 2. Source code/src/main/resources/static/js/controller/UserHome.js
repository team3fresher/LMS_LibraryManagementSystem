var app = angular.module('myApp');

app.controller('UserHome', function($scope, $http, $routeParams, productService, $rootScope,userService) {
	userService.update();
	$scope.status=userService.getUser();
	if(typeof($scope.status.status)=="undefined"){
		$scope.value=false;
	}
	else {
		$scope.value=true;
	}
	$scope.userData=[];
	getUser();
	function getUser() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/userInfo/get/" + $scope.status.username
		}).success(function(data) {
			$scope.userData=data;
		})
	}
	
	$scope.showTicket =function (){
		var x =$scope.selectTicket;
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/ticket/get/" + x
		}).success(function(data) {
			$scope.bookTickets=data;
			//console.log($scope.bookTickets)
		})
	}
});
