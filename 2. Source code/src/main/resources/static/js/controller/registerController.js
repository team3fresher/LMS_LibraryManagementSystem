var app = angular.module('myApp');

app.controller('registerController', function($scope, $http, $routeParams,$filter) {

	$scope.AddUser = function(){
		$scope.user = {  
			"address": $scope.user.address,
			"degree": $scope.user.degree,	
			"email": $scope.user.email,
			"job": $scope.user.job,
			"phoneNumber": $scope.user.phone,
			"pword": $scope.user.password,
			"realName": $scope.user.name,
			"sex": $scope.user.gender,
			"valid": 1,
			"roles": [
				  {
				    "roleId": 2
				  }
				],
			"dayofBirth":$scope.user.birthday,
		};
			$http.post("http://localhost:9000/LMS/userInfo/add",$scope.user)
			.success(function(data, status, headers, config){
				getData();
			})
			.error(function(data, status, headers, config){
			});
		
	}
	function getData() { 
		$http({
			method: 'get',
			url: "http://localhost:9000/LMS/userInfo/list"
		}).success(function(data, status, headers, config){
			$scope.users = data;
		})
		.error(function(data, status, headers, config){});
	}
});
var compareTo = function() {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function(scope, element, attributes, ngModel) {
             
            ngModel.$validators.compareTo = function(modelValue) {
                return modelValue == scope.otherModelValue;
            };
 
            scope.$watch("otherModelValue", function() {
                ngModel.$validate();
            });
        }
    };
};
 
app.directive("compareTo", compareTo);