var app = angular.module('myApp');

app.controller('BookUserController',function($scope, $http, $routeParams, productService,userService) {
	var size = 8;
	getCategory();
	getAuthor();
	getPublisher();
	$scope.addCart = function(x) {
		var newObj ={
				id:x.isbn,
				importance:x.importance
		};
		productService.addProduct(newObj);
	}
		if ($scope.selectCategory == null
							&& $scope.selectAuthor == null
							&& $scope.selectPublisher == null) {
			getData();
		}
	$scope.searchBooks = function() {
		if ($scope.selectCategory == null
									&& $scope.selectAuthor == null
									&& $scope.selectPublisher == null) {
			getData();
		} else if ($scope.selectCategory != null) {
			$scope.books = $scope.categories[$scope.selectCategory - 1].books;
			$scope.pagingShow = false;
		} else if ($scope.selectAuthor != null) {
			$scope.books = $scope.authors[$scope.selectAuthor - 1].books;
			$scope.pagingShow = false;
		} else if ($scope.selectPublisher != null) {
			$scope.books = $scope.publishers[$scope.selectPublisher - 1].books;
			$scope.pagingShow = false;
		}
	}
		function getData() {
						$http(
								{
									method : 'get',
									url : "http://localhost:9000/LMS/book/findAll?page=0&size="
											+ size
								}).success(
								function(data, status, headers, config) {
									$scope.books = data.content;
									$scope.currentPage = 1;
									$scope.totalPages = data.totalPages;
									if (data.totalElements > size) {
										$scope.pagingShow = true;
									}
								}).error(
								function(data, status, headers, config) {
								});
					}
					function getCategory() {
						$http({
							method : 'get',
							url : "http://localhost:9000/LMS/category/list"
						}).success(function(data) {
							$scope.categories = data;
						})
					}
					function getAuthor() {
						$http({
							method : 'get',
							url : "http://localhost:9000/LMS/author/list"
						}).success(function(data) {
							$scope.authors = data;
						})
					}
					function getPublisher() {
						$http({
							method : 'get',
							url : "http://localhost:9000/LMS/publisher/list"
						}).success(function(data) {
							$scope.publishers = data;
						})
					}

					// Start Paging
					$scope.incPaging = function(currentPage) {
						if (currentPage == $scope.totalPages) {

						} else {
							pageNumb = parseInt(currentPage) + 1;
							$scope.currentPage = pageNumb;
							$http(
									{
										method : 'get',
										url : "http://localhost:9000/LMS/book/findAll?page="
												+ (pageNumb - 1)
												+ "&size="
												+ size
									}).success(
									function(data, status, headers, config) {
										$scope.books = data.content;
									}).error(
									function(data, status, headers, config) {
									});
						}
					}

					$scope.desPaging = function(currentPage) {
						if (currentPage == 1) {

						} else {
							pageNumb = parseInt(currentPage) - 1;
							$scope.currentPage = pageNumb;
							$http(
									{
										method : 'get',
										url : "http://localhost:9000/LMS/book/findAll?page="
												+ (pageNumb - 1)
												+ "&size="
												+ size
									}).success(
									function(data, status, headers, config) {
										$scope.books = data.content;
									}).error(
									function(data, status, headers, config) {
									});
						}
					}
					// end Paging

				});
