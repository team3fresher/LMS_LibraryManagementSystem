var app = angular.module('myAdmin');
app.controller("IssueBookController", function($scope, $http, $routeParams) {
	$scope.id = $routeParams.id;
	
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