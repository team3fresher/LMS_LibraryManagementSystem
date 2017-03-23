var app = angular.module('myAdmin');
app.controller("CategoryController", function($scope, $http){		
	
	var size=10;	
	
	$scope.AddCategory = function(){
		$scope.category= {
			"categoryName":$scope.category.categoryName,
			"categoryDescription":$scope.category.categoryDescription,
		};
		console.log($scope.category);
			$http.post("http://localhost:9000/LMS/category/add",$scope.category)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){				
			});			
	}
	$scope.removeCategory = function(x){
		//$scope.users.splice(x, 1);
		$('#myModalDelete-' + x).modal().hide();
		$('.modal-backdrop').hide();
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/remove/"+x
		}).success(function(data, status, headers, config){
			$scope.users = data;
			getData();
		})
		.error(function(data, status, headers, config){
			getData();
		});
		
	}
	$scope.orderByMe = function(x){
		$scope.myOrderBy = x;
	}

	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/category/findAll?page=0&size="+size
		}).success(function(data, status, headers, config){
			$scope.categories = data.content;				
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
				url: "http://localhost:9000/LMS/category/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.categories = data.content;			
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
				url: "http://localhost:9000/LMS/category/findAll?page="+(pageNumb-1)+"&size="+size
			}).success(function(data, status, headers, config){
				$scope.categories = data.content;			
			})
			.error(function(data, status, headers, config){});
		}		
	}
	//end Paging
})