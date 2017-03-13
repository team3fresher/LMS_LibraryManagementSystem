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
            controller: 'MainController'
        })
        .when('/bookdetail',{
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
        .when('/cart',{
            templateUrl: '/LMS/views/cart.html',
            controller: 'MainController'
        })
        .when('/admin',{
            templateUrl: '/LMS/indexAdmin.html',
            controller: 'MainController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

