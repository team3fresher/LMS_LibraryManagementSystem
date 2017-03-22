var app = angular.module('myAdmin');
app.controller("IssueBookController", function($scope, $http, $routeParams) {
	$scope.id = $routeParams.id;
	getData();
	
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	
	$scope.issueDetail = function() {
		
	}

	function getData() {
		$http({
			method : 'get',
			url : 'http://localhost:9000/LMS/ticket/list'
		}).success(function(data, status, headers, config) {
			$scope.tickets = data;
			console.log('load ticket OK');
		}).error(function(data, status, headers, config) {
		});
	}
	
	function getDataById(id) {
		$http({
			method : 'get',
			url : 'http://localhost:9000/LMS/ticket/get/' + id
		}).success(function(data, status, headers, config) {
			$scope.ticket = data;
			console.log('load ticket OK');
		}).error(function(data, status, headers, config) {
		});
	}
});