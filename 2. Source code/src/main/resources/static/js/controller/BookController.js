var app = angular.module('myAdmin');
app.controller("BookController", function($scope, $http){
		
	$scope.AddBook = function(){
app.controller("BookController", function($scope, $http) {
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
	
	$scope.AddBook = function() {
		$scope.book = {
				"isbn": $scope.book.isbn,
			    "amount": $scope.book.amount,
			    "brwTcktNber": 0,
			    "importance": $scope.book.importance,
			    "publishingYear": $scope.book.publish,
			    "shortDescription": $scope.book.note,
			    "title": $scope.book.title,
			    "validStatus": 1
			"isbn" : $scope.book.isbn,
			"amount" : $scope.book.amount,
			"brwTcktNber" : 0,
			"importance" : $scope.book.importance,
			"publishingYear" : $scope.book.publishYear,
			"shortDescription" : $scope.book.note,
			"title" : $scope.book.title,
			"validStatus" : $scope.book.validStatus,
			"authorDetails" : toObjectArray($scope.authorData.model),
			"bookCategoryDetail" : {
				'categoryId' : $scope.categoryData.model
			},
			"publisherDetail" : {
				'publisherId' : $scope.publisherData.model
			},
			"ticketBookUsers" : []
		};
			$http.post("http://localhost:9000/LMS/book/add",$scope.book)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){});
		
		$http.post("http://localhost:9000/LMS/book/add", $scope.book).success(
				function(data, status, headers, config) {
					getData();
					console.log('Add book OK');
				}).error(function(data, status, headers, config) {
		});

	}
	$scope.orderByMe = function(x){
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	
	function toObjectArray(data) {
		var output = [];
		for(var i = 0; i < data.length; i++) {
			output[i] = {'authorId':data[i]};
		}
		return output;
	}

	function getData() { 
	function getData() {
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/book/list"
		}).success(function(data, status, headers, config){
			method : 'get',
			url : "http://localhost:9000/LMS/book/list"
		}).success(function(data, status, headers, config) {
			$scope.books = data;
		})
		.error(function(data, status, headers, config){});
		}).error(function(data, status, headers, config) {
		});
	}
	getData();
	
	















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
			//console.log(temp);
			$scope.categoryData.availableOptions = temp;
			//console.log($scope.categoryData.availableOptions);
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
			//console.log(temp);
			$scope.publisherData.availableOptions = temp;
			//console.log($scope.publisherData.availableOptions);
		}).error(function(data, status, headers, config) {
		});
	}
})