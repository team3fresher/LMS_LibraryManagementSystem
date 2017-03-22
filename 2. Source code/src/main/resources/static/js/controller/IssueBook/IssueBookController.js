var app = angular.module('myAdmin');
app.controller("IssueBookController", function($scope, $http) {
	getData();
	
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}

	function getData() {
		$http({
			method : 'get',
			url : 'http://localhost:9000/LMS/ticket/list'
		}).success(function(data, status, headers, config) {
			$scope.tickets = data;
			console.log('load list ticket OK');
		}).error(function(data, status, headers, config) {
		});
	}
});