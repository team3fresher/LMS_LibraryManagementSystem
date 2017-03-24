var app = angular.module('myAdmin');
app.controller("BookController", function($scope, $http) {

	getData();
	var size=10;
	
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	function getData() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/book/findAll?page=0&size="+size
		}).success(function(data, status, headers, config) {
			$scope.books = data.content;
			$scope.currentPage = 1;
			$scope.totalPages = data.totalPages;
			if(data.totalElements > size){
				$scope.pagingShow=true;
			}
		}).error(function(data, status, headers, config) {
		});
	}
	
	// Remove book
	$scope.removeBook = function(isbn) {
		$('#myModalDelete-' + isbn).modal().hide();
		$('.modal-backdrop').hide();
		$http.get("http://localhost:9000/LMS/book/remove/" + isbn)
		.success(function(){
			getData();
			console.log('remove book OK');
		})
		.error(function(){
			getData();
		})
	}
	
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
});
