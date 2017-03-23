var app = angular.module('myAdmin');

app.controller('AdminController', function($scope, $http, $routeParams) {
	
	getNumberUser();
	
	function getNumberUser() {
		console.log('get number user');
		$http.get('http://localhost:9000/LMS/userInfo/getTotalUser').then(
				function(response){
					$scope.total = response.data[0];
					$scope.male = response.data[1];
					$scope.female = response.data[2];
					console.log(response.data);
				}, 
				function(response){
					console.log('error');
				});
	}
});