var app = angular.module('myAdmin');
app.controller("CategoryControler", function($scope, $http){
		
	$scope.AddCategory = function(){
		$scope.category= {
			
		};
			$http.post("http://localhost:9000/LMS/category/add",$scope.category)
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
			url: "http://localhost:9000/LMS/category/list"
		}).success(function(data, status, headers, config){
			$scope.book = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	
})