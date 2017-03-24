var app = angular.module('myAdmin');
app.controller("IssueBookController", function($scope, $http) {
	getData();
	
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
	$scope.returnBook = function(x){
			/*var date = new Date();
			$scope.returnTicket = {
					"returnedDate": date,
					"ticket": {
					  "ticketId": x
					},	
			}
			$http.post("http://localhost:9000/LMS/returnBook/add",$scope.returnTicket)
			.success(function(data ){
				//alert("Add user success!!");
				
			})
			.error(function(data, status, headers, config){
				//alert("Add user error!!");

			});*/
			$http({
				method: 'get',
				url: "http://localhost:9000/LMS/ticket/remove/"+x
			}).success(function(data, status, headers, config){
				$scope.tickets = data;
				getData();
			})
			.error(function(data, status, headers, config){
				getData();
			});
	}
	function getData() {
		$http({
			method : 'get',
			url : 'http://localhost:9000/LMS/ticket/list'
		}).success(function(data, status, headers, config) {
			$scope.tickets = data;
			console.log('load list ticket OK');
		}).error(function(data, status, headers, config) {
		});
	}
});