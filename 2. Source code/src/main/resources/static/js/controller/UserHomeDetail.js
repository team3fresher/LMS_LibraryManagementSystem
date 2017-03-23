var app = angular.module('myApp');
app.controller("UserHomeDetail", function($scope, $http, $routeParams) {
	$scope.EditUser = function() {
		$scope.temp = {
			userId : $scope.iduser,
			address : $scope.address,
			degree : $scope.degree,
			email : $scope.email,
			job : $scope.job,
			phoneNumber : $scope.phone,
			pword : $scope.password,
			realName : $scope.name,
			sex : $scope.gender,
			valid : 1,
			roles: [
			    	  {
			    	    "roleId": 2
			    	  }
			    	],
			dayofBirth : $scope.day
		}
		$http.post("http://localhost:9000/LMS/userInfo/add", $scope.temp)
				.success(function(data, status, headers, config) {
					// alert("Add user success!!");

				}).error(function(data, status, headers, config) {
					// alert("Add user error!!");
				});
		

	}
	function getUser() {
		$http({
			method : 'get',
			url : "http://localhost:9000/LMS/userInfo/get/" + $routeParams.id
		}).success(function(data) {
			$scope.iduser = data.userId;
			$scope.address = data.address;
			$scope.degree = data.degree;
			$scope.email = data.email;
			$scope.job = data.job;
			$scope.phone = data.phoneNumber;
			$scope.password = data.pword;
			$scope.name = data.realName;
			$scope.gender = data.sex;
			$scope.day = data.dayofBirth
		})
	}
	getUser();
})
