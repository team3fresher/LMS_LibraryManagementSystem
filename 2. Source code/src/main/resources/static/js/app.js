var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
	    .when('/',{
	        templateUrl: '/LMS/views/home.html',
	        controller: 'MainController'
	    })
	    .when('/register',{
            templateUrl: '/LMS/views/registration.html',
            controller: 'registerController'
        })
        .when('/main',{
            templateUrl: '/LMS/views/main.html',
            controller: 'MainController'
        })
        .when('/book',{
            templateUrl: '/LMS/views/book.html',
            controller: 'BookUserController'
        })
        .when('/book/bookdetail',{
            templateUrl: '/LMS/views/bookdetail.html',
            controller: 'bookDetailController'
        })
        .when('/book/bookdetail/:id',{
            templateUrl: '/LMS/views/bookdetail.html',
            controller: 'bookDetailController'
        })
        .when('/author',{
            templateUrl: '/LMS/views/author.html',
            controller: 'MainController'
        })
        .when('/user',{
            templateUrl: '/LMS/views/user.html',
            controller: 'MainController'
        })
        .when('/user/updateuser',{
	        templateUrl: '/LMS/views/admin/update_user.html',
	        controller: 'userDetailCtr'
	    })
        .when('/cart',{
            templateUrl: '/LMS/views/cart.html',
            controller: 'MainController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

