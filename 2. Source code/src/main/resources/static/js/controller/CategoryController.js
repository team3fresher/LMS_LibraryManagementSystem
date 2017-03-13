var app = angular.module('myAdmin');
app.controller("CategoryController", function($scope, $http){
		
	$scope.AddCategory = function(category){		
			$http.post("http://localhost:9000/LMS/category/add",category)
			.success(function(data, status, headers, config){				
			})
			.error(function(data, status, headers, config){				
			});			
			$scope.category={categoryName:" ", categoryDescription:""};
	}
	$scope.orderByMe = function(x){
		$scope.myOrderBy = x;
	}

	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/list"
		}).success(function(data, status, headers, config){
			$scope.categories = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();		
})