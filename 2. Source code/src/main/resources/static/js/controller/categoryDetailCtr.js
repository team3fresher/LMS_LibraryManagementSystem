var app = angular.module('myAdmin');
app.controller("categoryDetailCtr", function($scope, $http, $routeParams) {
	$scope.EditCategory = function() {
		$scope.temp = {
			categoryId : $scope.idcategory,
			categoryName  :$scope.name,
			categoryDescription:$scope.description,	
		}
		$http.post("http://localhost:9000/LMS/category/add", $scope.temp)
				.success(function(data, status, headers, config) {
					// alert("Add user success!!");

				}).error(function(data, status, headers, config) {
					// alert("Add user error!!");
				});
	}
	function getCategory() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/category/get/" + $routeParams.id
		}).success(function(data) {
			$scope.idcategory = data.categoryId;
			$scope.name = data.categoryName;
			$scope.description = data.categoryDescription;
		})
	}
	getCategory();
})
