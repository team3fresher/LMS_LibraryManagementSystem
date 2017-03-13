var app = angular.module('myAdmin');
app.controller("AuthorController", function($scope, $http){
		
	$scope.AddAuthor = function(){
		$scope.author = {
			"authorName": $scope.author.name,
			
		};
			$http.post("http://localhost:9000/LMS/author/add",$scope.author)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){});
		
	}
	$scope.orderByMe = function(x){
		$scope.myOrderBy = x;
	}

	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/author/list"
		}).success(function(data, status, headers, config){
			$scope.authors = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	
})