var app = angular.module('myAdmin');
app.controller("BookControler", function($scope, $http){
		
	$scope.AddBook = function(){
		$scope.book = {
			
		};
			$http.post("http://localhost:9000/LMS/book/add",$scope.book)
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
			url: "http://localhost:9000/LMS/book/list"
		}).success(function(data, status, headers, config){
			$scope.book = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	
})