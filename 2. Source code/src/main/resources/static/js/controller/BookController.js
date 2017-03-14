var app = angular.module('myAdmin');
app.controller("BookController", function($scope, $http){
		
	var size=10;
	
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
			url: "http://localhost:9000/LMS/book/findAll?page=0&size="+size
		}).success(function(data, status, headers, config){
			$scope.books = data.content;
			$scope.currentPage = 1;
			$scope.totalPages = data.totalPages;
			if(data.totalElements > size){
				$scope.pagingShow=true;
			}
		})
		.error(function(data, status, headers, config){});
	}
	getData();
	
	//Start Paging
	$scope.incPaging = function(currentPage){
		if(currentPage == $scope.totalPages){
			
		}else{
			pageNumb = parseInt(currentPage)+1;
			$scope.currentPage = pageNumb;	
			$http({
				method: 'get',
				url: "http://localhost:9000/LMS/book/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.books = data.content;			
			})
			.error(function(data, status, headers, config){});
		}	
	}
	
	$scope.desPaging = function(currentPage){
		if(currentPage == 1){
			
		}else{
			pageNumb = parseInt(currentPage)-1;
			$scope.currentPage = pageNumb;	
			$http({
				method: 'get',
				url: "http://localhost:9000/LMS/book/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.books = data.content;			
			})
			.error(function(data, status, headers, config){});
		}		
	}
	//end Paging
})