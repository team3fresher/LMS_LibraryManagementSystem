var app = angular.module('myAdmin', ['ngRoute','ngResource', 'ng-fusioncharts']);
app.config(function($routeProvider){
    $routeProvider
	    .when('/',{
	        templateUrl: '/LMS/views/admin/home.html',
	        controller: 'AdminController'
	    })
	    .when('/booksManage',{
	        templateUrl: '/LMS/views/admin/book_management.html',
	        controller: 'BookController'
	    })
	    .when('/booksManage/addbook',{
	        templateUrl: '/LMS/views/admin/add_book.html',
	        controller: 'BookDetailController'
	    })
	    .when('/booksManage/updatebook/:isbn',{
	        templateUrl: '/LMS/views/admin/update_book.html',
	        controller: 'BookDetailController'
	    })
	    .when('/ticketsManage',{
	        templateUrl: '/LMS/views/admin/ticket_detail.html',
	        controller: 'AdminController'
	    })
	    .when('/categoryManage',{
	        templateUrl: '/LMS/views/admin/category_management.html',
	        controller: 'CategoryController'
	    })
	    .when('/categoryManage/addcategory',{
	        templateUrl: '/LMS/views/admin/add_category.html',
	        controller: 'CategoryController'
	    })
	    .when('/categoryManage/updatecategory/:id',{
	        templateUrl: '/LMS/views/admin/update_category.html',
	        controller: 'categoryDetailCtr'
	    })
	    .when('/authorManage',{
	        templateUrl: '/LMS/views/admin/author_management.html',
	        controller: 'AuthorController'
	    })
	    .when('/authorManage/addauthor',{
	        templateUrl: '/LMS/views/admin/add_author.html',
	        controller: 'AuthorController'
	    })
	    .when('/authorManage/updateauthor/:id',{
	        templateUrl: '/LMS/views/admin/update_author.html',
	        controller: 'authorDetailCtr'
	    })
	    .when('/userManage',{
	        templateUrl: '/LMS/views/admin/user_management.html',
	        controller: 'UserController'
	    })
	    .when('/userManage/adduser',{
	        templateUrl: '/LMS/views/admin/add_user.html',
	        controller: 'UserController'
	    })
	    .when('/userManage/updateuser/:id',{
	        templateUrl: '/LMS/views/admin/update_user.html',
	        controller: 'userDetailCtr'
	    })
	    .when('/borrowBook',{
	        templateUrl: '/LMS/views/admin/borrow_book.html',
	        controller: 'IssueBookController'
	    })
	    .when('/borrowBook/ticketDetail/:id',{
	        templateUrl: '/LMS/views/admin/ticket_detail.html',
	        controller: 'IssueBookDetailController'
	    })
	    .when('/returnBook',{
	        templateUrl: '/LMS/views/admin/return_book.html',
	        controller: 'ReturnBookController'
	    })
	    .when('/returnBook/ticketDetail',{
	        templateUrl: '/LMS/views/admin/ticket_detail.html',
	        controller: 'AdminController'
	    })
	    .when('/rules',{
	        templateUrl: '/LMS/views/admin/rules.html',
	        controller: 'AdminRules'
	    })
	    .when('/blacklist',{
	        templateUrl: '/LMS/views/admin/blacklist.html',
	        controller: 'AdminController'
	    })
	    .when('/reports',{
	        templateUrl: '/LMS/views/admin/reports.html',
	        controller: 'AdminReportController'
	    })
	    .when('/test',{
	        templateUrl: '/LMS/book_management.html',
	        controller: 'AdminController'
	    })	    
        .otherwise(
            { redirectTo: '/'}
        );
});

