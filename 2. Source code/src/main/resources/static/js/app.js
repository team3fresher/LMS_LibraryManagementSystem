var app = angular.module('myApp', ['ngRoute','ngResource', 'ui.bootstrap', 'ngCookies']);
app.config(function($routeProvider){    
	$routeProvider.when('/', {
	        templateUrl: '/LMS/views/home.html',
	        controller: 'MainController'
	}).when('/register', {
            templateUrl: '/LMS/views/registration.html',
            controller: 'registerController'
	}).when('/login', {
        templateUrl: 'login.html',
        controller: 'registerController'
    }).when('/book',{
        templateUrl: '/LMS/views/book.html',
        controller: 'BookUserController'
	}).when('/search/:id', {
		templateUrl : '/LMS/views/searchBook.html',
		controller : 'searchController'
	}).when('/book/bookdetail', {
            templateUrl: '/LMS/views/bookdetail.html',
            controller: 'bookDetailController'
	}).when('/book/bookdetail/:id', {
            templateUrl: '/LMS/views/bookdetail.html',
            controller: 'bookDetailController'
	}).when('/author', {
            templateUrl: '/LMS/views/author.html',
            controller: 'MainController'
	}).when('/user', {
            templateUrl: '/LMS/views/user.html',
            controller: 'UserHome'
	}).when('/user/updateuser/:id', {
	        templateUrl: '/LMS/views/admin/update_user.html',
	        controller: 'UserHomeDetail'
	}).when('/cart', {
            templateUrl: '/LMS/views/cart.html',
		controller : 'cartController'
	}).otherwise({
		redirectTo : '/'
	});
});
app.service('productService', function($cookies) {
	if ($cookies.getObject('myCart')==null){
	var productList = [];
	} else {
		var productList=$cookies.getObject('myCart');
	}
	//console.log($cookies.getObject('myCart')==null)
	var addProduct = function(newObj) {
		if(newObj.importance==1){
			alert("Book only read in library!!!")
		} else {
		var count = 0;
		for (var i = 0; i < productList.length; i++) {
			if (productList[i].id == newObj.id) {
				//productList[i].valuable += 1;
				alert("Already in cart!")
				break;
			}
			count++;
		}
		if (count == productList.length) {
			productList.push(newObj);
			$cookies.putObject('myCart', productList);
		}
		}
		//$cookies.putObject('myCart', productList);
	};

	var getProducts = function() {
		
		return productList;
	};
	var updateNumProducts = function(x, y) {
		for (var i = 0; i < productList.length; i++) {
			if (productList[i].id == x) {
				productList[i].valuable = y;
				break;
			}
		}
		$cookies.putObject('myCart', productList);
	};
	var removeProducts = function(x) {
		for (var i = 0; i < productList.length; i++) {
			if (productList[i].id == x) {
				productList.splice(i, 1);
				break;
			}
		}
		$cookies.putObject('myCart', productList);
		
	};
	var cancelProducts = function() {
		$cookies.remove('myCart');
	}
	return {
		addProduct : addProduct,
		getProducts : getProducts,
		updateNumProducts : updateNumProducts,
		removeProducts : removeProducts,
		cancelProducts : cancelProducts
	};

});
app.service('userService', function($cookies,$http) {
	if ($cookies.getObject('userDetail')==null){
		var user = [];
		} else {
			var user=$cookies.getObject('userDetail');
		}
	getData();
	var getUser = function() {	
		return user;
	};
	var update = function() {	
		getData();
	};
	
	function getData(){ 
		
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/userInfo/userDetail"
	}).success(function(data){
		var userInfo = data;
		//console.log(data)
		//console.log($scope.userData)
		//console.log($scope.userData.userId)
		if(typeof(userInfo.userId) == "undefined"){
			alert("Login")	
			$cookies.remove('userDetail');
			user = []
		} else{
			var status ={
					username: userInfo.userId,
					status: 1
			}
			$cookies.putObject('userDetail',status);
			user=$cookies.getObject('userDetail');
		}
	});
	}
	return {
		getUser : getUser,
		update : update

	};
});