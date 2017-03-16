var app = angular.module('myAdmin');
app.controller("BookController", function($scope, $http, $routeParams) {
	$scope.updatebook = {};
	$scope.isbn = $routeParams.isbn;
	$scope.authors = [];
	$scope.categories = [];
	$scope.publishers = [];
	$scope.authorDetails1 = [];
	$scope.authorData = {
		model : null,
		availableOptions : []
	};
	$scope.categoryData = {
		model : null,
		availableOptions : []
	};
	$scope.publisherData = {
		model : null,
		availableOptions : []
	};

	getAuthorData();
	getCategoryData();
	getPublisherData();

	getBookDataByISBN($scope.isbn);
	$scope.AddBook = function() {
		$scope.book = {
			"isbn" : $scope.book.isbn,
			"amount" : $scope.book.amount,
			"brwTcktNber" : 0,
			"importance" : $scope.book.importance,
			"publishingYear" : $scope.book.publishYear,
			"shortDescription" : $scope.book.note,
			"title" : $scope.book.title,
			"validStatus" : $scope.book.validStatus,
			//"authorDetails" : toObjectArray($scope.authorData.model),
			"authorDetails" : $scope.authorData.model.map(function(e) {
			    return { 'authorId': e };
			}),
			"bookCategoryDetail" : {
				'categoryId' : $scope.categoryData.model
			},
			"publisherDetail" : {
				'publisherId' : $scope.publisherData.model
			},
			"ticketBookUsers" : []
		};
		console.log($scope.book);
		$http.post("http://localhost:9000/LMS/book/add", $scope.book).success(
				function(data, status, headers, config) {
					getData();
					console.log('Add book OK');
				}).error(function(data, status, headers, config) {
		});

	}

	$scope.UpdateBook = function(isbn) {
		$scope.updatebook = {
			"isbn" : isbn,
			"amount" : $scope.updatebook.amount,
			"brwTcktNber" : 0,
			"importance" : $scope.updatebook.importance,
			"publishingYear" : $scope.updatebook.publishingYear,
			"shortDescription" : $scope.updatebook.shortDescription,
			"title" : $scope.updatebook.title,
			"validStatus" : $scope.updatebook.validStatus,
			"authorDetails" : toObjectArray($scope.authorData.model),
			"bookCategoryDetail" : {
				'categoryId' : $scope.categoryData.model
			},
			"publisherDetail" : {
				'publisherId' : $scope.publisherData.model
			},
			"ticketBookUsers" : []
		};
		console.log($scope.updatebook);
		$http.post("http://localhost:9000/LMS/book/edit", $scope.book).success(
				function(data, status, headers, config) {
					getData();
					console.log('edit book OK');
				}).error(function(data, status, headers, config) {
		});
	}

	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}

	function toObjectArray(data) {
		var output = [];
		for (var i = 0; i < data.length; i++) {
			output[i] = {
				'authorId' : data[i]
			};
		}
		return output;
	}

	function getData() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/book/list"
		}).success(function(data, status, headers, config) {
			$scope.books = data;

		}).error(function(data, status, headers, config) {
		});
	}
	getData();

	function getBookDataByISBN(isbn) {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/book/get/" + isbn
		}).success(function(data, status, headers, config) {
			$scope.updatebook = data;
			console.log("load book by isbn: ok");
			console.log($scope.updatebook);
		}).error(function(data, status, headers, config) {
			console.log("Load book by isbn: fail");
		});
	}

	function getAuthorData() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/author/list"
		}).success(function(data, status, headers, config) {
			$scope.authors = data;
			console.log('add author: ok');
			var values = $scope.authors;
			var temp = [];

			console.log($scope.authors.length);
			angular.forEach(values, function(value, key) {
				var parent = new Object();
				/*
				 * var obj = new Object(); obj.authorId = value.authorId;
				 * obj.authorName = value.authorName; console.log(obj);
				 */
				parent.value = value.authorId;
				parent.name = value.authorName;
				temp.push(parent);
			});
			// console.log(temp);
			$scope.authorData.availableOptions = temp;
			// console.log($scope.authorData.availableOptions);
		}).error(function(data, status, headers, config) {
		});
	}

	function getCategoryData() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/category/list"
		}).success(function(data, status, headers, config) {
			$scope.categories = data;
			console.log('add category: ok');
			var values = $scope.categories;
			var temp = [];

			console.log($scope.categories.length);
			angular.forEach(values, function(value, key) {
				var obj = new Object();
				obj.id = value.categoryId;
				obj.name = value.categoryName;
				temp.push(obj);
			});
			// console.log(temp);
			$scope.categoryData.availableOptions = temp;
			// console.log($scope.categoryData.availableOptions);
		}).error(function(data, status, headers, config) {
		});
	}

	function getPublisherData() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/publisher/list"
		}).success(function(data, status, headers, config) {
			$scope.publishers = data;
			console.log('add publisher: ok');
			var values = $scope.publishers;
			var temp = [];

			console.log($scope.publishers.length);
			angular.forEach(values, function(value, key) {
				var obj = new Object();
				obj.id = value.publisherId;
				obj.name = value.publisherName;
				temp.push(obj);
			});
			// console.log(temp);
			$scope.publisherData.availableOptions = temp;
			// console.log($scope.publisherData.availableOptions);
		}).error(function(data, status, headers, config) {
		});
	}
});

app.directive('checkIsbn1', function($http) {
	return {
		require : 'ngModel',
		link : function(scope, element, attr, mCtrl) {
			scope.$watch(attr.ngModel, function(value){
				$http({
					method : 'get',
					url : "http://localhost:9000/LMS/book/check/" + value
				}).success(function(data, status, headers, config) {
					console.log(data);
					if (angular.equals(data, true)) {
						mCtrl.$setValidity('checkIsbn', true);
					} else {
						mCtrl.$setValidity('checkIsbn', false);
					}
					return value;
				}).error(function(data, status, headers, config) {
					return null;
				});
			});
		}
	};
});