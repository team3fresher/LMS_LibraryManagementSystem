var app = angular.module('myAdmin');
app.controller("AuthorController",function($scope, $http){
		
	var size=10;	

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
			url: "http://localhost:9000/LMS/author/findAll?page=0&size="+size
		}).success(function(data, status, headers, config){
			$scope.authors = data.content;			
			$scope.currentPage = 1;
			$scope.totalPages = data.totalPages;
		})
		.error(function(data, status, headers, config){});
	}
	getData();			

	//Start Paging
	$scope.incPaging = function(currentPage){
		if(currentPage == 5){
			
		}else{
			pageNumb = parseInt(currentPage)+1;
			$scope.currentPage = pageNumb;	
			$http({
				method: 'get',
				url: "http://localhost:9000/LMS/author/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.authors = data.content;			
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
				url: "http://localhost:9000/LMS/author/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.authors = data.content;			
			})
			.error(function(data, status, headers, config){});
		}		
	}
	//end Paging
})