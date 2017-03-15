var app = angular.module('myAdmin');
app.controller("authorDetailCtr", function($scope, $http, $routeParams) {
	$scope.EditAuthor = function() {
		$scope.temp = {
			authorId : $scope.idauthor,
			authorName : $scope.name,	
		}
		$http.post("http://localhost:9000/LMS/author/add", $scope.temp)
				.success(function(data, status, headers, config) {
					// alert("Add user success!!");

				}).error(function(data, status, headers, config) {
					// alert("Add user error!!");
				});
		

	}
	function getAuthor() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/author/get/" + $routeParams.id
		}).success(function(data) {
			$scope.idauthor = data.authorId;
			$scope.name = data.authorName;
		})
	}
	getAuthor();
})
