var app = angular.module('myApp');

app.controller('cartController',function($scope, $http, $routeParams,
		productService,userService,$cookies) {
	userService.update();
	$scope.status=userService.getUser();
	$scope.userData=[];
	getUser();
	function getUser() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/userInfo/get/" + $scope.status.username
		}).success(function(data) {
			$scope.userData=data;
		})
	}
	$scope.bookCarts = [];
	$scope.userdate = new Date();
	$scope.products = productService.getProducts();
	//console.log($scope.products);
	getCartInfor();
	//console.log($scope.bookCarts);
	$scope.removeCart = function(x) {
		productService.removeProducts(x);
		$scope.bookCarts = [];
		getCartInfor();
		//$scope.bookCarts.splice(x, 1);
		//$scope.products.splice(x, 1);
	}
	$scope.cancelTicket = function() {
		productService.cancelProducts();
		$scope.bookCarts = [];
		//var len = $scope.products.length;
		//$scope.bookCarts.splice(0, len);
		//$scope.products.splice(0, len);

	}
	/*$scope.addNumberTicket = function(id) {
		for (var i=0 ; i<$scope.bookCarts.length; i++) {
			if ($scope.bookCarts[i].isbn==id){
				var temp =$scope.bookCarts[i].amount - $scope.bookCarts[i].brwTcktNber;
				if($scope.bookCarts[i].valuable == temp ){
					$scope.bookCarts[i].valuable = temp;
				}
				else {
					$scope.bookCarts[i].valuable += 1;
				}
				productService.updateNumProducts(id,$scope.bookCarts[i].valuable)
				break;
			}
		}
		//console.log(id);
		//console.log($scope.bookCarts[x].valuable);
		
	}
	$scope.subNumberTicket = function(id) {
		for (var i=0 ; i<$scope.bookCarts.length; i++) {
			if ($scope.bookCarts[i].isbn==id){
				if($scope.bookCarts[i].valuable ==0){
					$scope.bookCarts[i].valuable=0;
				}
				else {
				$scope.bookCarts[i].valuable -= 1;
				}
				productService.updateNumProducts(id,$scope.bookCarts[i].valuable)
				break;
			}
		}
		
	}*/
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	
	$scope.AddTicket= function(){
		//var num= getNumBorrow();
		//var numberOfDaysToAdd = 14;
		//$scope.newdate = $scope.userdate.setDate($scope.userdate.getDate() + numberOfDaysToAdd); 
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/userInfo/get/" + $scope.status.username
		}).success(function(data) {
		var num =data.tickets.length;
		//console.log(num);
		var count=0;
		for (var i=0; i<num; i++){
			count+=$scope.userData.tickets[i].borrowNumber;
			//console.log($scope.userData.tickets[i].borrowNumber);
		}
		count+=$scope.products.length;
		//console.log(count);
		if(count > 5){
			alert("Da muon qua nhieu")
		} else{
		var arrBooks = [];
		$scope.ticket={
				"borrowNumber": $scope.products.length, //num,
				"borrowedDate": $scope.userdate,
				"userInfo": {
			    	"userId": $scope.userData.userId
				},
				//"books":$scope.bookCarts	
		}
		//console.log($scope.ticket)
		$http.post("http://localhost:9000/LMS/ticket/add",$scope.ticket)
		.success(function(data, status, headers, config){
			//alert("Add user success!!");
			
		})
		.error(function(data, status, headers, config){
			//alert("Add user error!!");		
		});		
		for(var i=0; i<$scope.products.length; i++){
			$http({
				method : 'get',
				url : "http://localhost:9000/LMS/book/get/" + $scope.products[i].id
			}).success(function(dataBook){
				dataBook.brwTcktNber += 1;
				$http.post("http://localhost:9000/LMS/book/edit", dataBook).success(
						function(data, status, headers, config) {
							console.log("update ok");	        						
						}).error(function(data, status, headers, config) {
				});
			})
			
		}
		}
	});
		$scope.cancelTicket();
		//borrow ticket number update after register book.
		//get list book to get full information of books
		//BUG: if tickets of book has value then update fail?x
	/*	$http.get("http://localhost:9000/LMS/book/list")
	    .then(function(response) {
	        arrBooks = response.data;	        
	        for (var int = 0; int < arrBooks.length; int++) {
	        	angular.forEach($scope.bookCarts, function(value, key){ 
	        		if(value.isbn == arrBooks[int].isbn){
	        			arrBooks[int].brwTcktNber += 1;value.valuable;
	        			value.brwTcktNber += value.valuable	        			
	        			console.log(arrBooks[int]);
//	        			var test = arrBooks[int];
	        			$http.post("http://localhost:9000/LMS/book/edit", arrBooks[int]).success(
	        					function(data, status, headers, config) {
	        						console.log("update ok");	        						
	        					}).error(function(data, status, headers, config) {
	        			});
	        		}
	        	});	        	
			}
	    });*/
		
	}
	function getNumBorrow(){
		var len = $scope.bookCarts.length;
		var num=0;
		for (var i = 0; i < len; i++) {
			num+= $scope.bookCarts[i].valuable;
		}
		return num;
	}
	function getCartInfor() {
		var len = $scope.products.length;
		for (var i = 0; i < len; i++) {
			var index = $scope.products[i].id;
			getData(index, $scope.products[i].valuable);
		}
	}
		
	function getData(x,num) {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/book/get/" + x
		}).success(function(data, status, headers, config) {
			data.valuable = num;
			$scope.bookCarts.push(data);
		}).error(function(data, status, headers, config) {
		});
	}
	function checkUser(){
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/userInfo/get/" + $scope.status.username
		}).success(function(data) {
		var num =data.tickets.length;
		//console.log(num);
		var count=0;
		for (var i=0; i<num; i++){
			count+=$scope.userData.tickets[i].borrowNumber;
			//console.log($scope.userData.tickets[i].borrowNumber);
		}
		count+=$scope.products.length;
		console.log(count);
		if(count > 2){
			alert("Da muon qua nhieu")
			$scope.add= -1;
		} 
		})
	}
});
