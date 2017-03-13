var app = angular.module('myAdmin');
app.controller("BookController", function($scope, $http){
		
	$scope.AddBook = function(){
		$scope.book = {
				"isbn": $scope.book.isbn,
			    "amount": $scope.book.amount,
			    "brwTcktNber": 0,
			    "importance": $scope.book.importance,
			    "publishingYear": $scope.book.publish,
			    "shortDescription": $scope.book.note,
			    "title": $scope.book.title,
			    "validStatus": 1
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
			$scope.books = data;
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	
})