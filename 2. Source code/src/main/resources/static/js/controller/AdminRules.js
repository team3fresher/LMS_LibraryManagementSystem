var app = angular.module('myAdmin');

app.controller('AdminRules', function($scope, $http) {
	function init(){
		$http.get("http://localhost:9000/LMS/rule/limit")
	    .then(function(response) {
	        $scope.limitation = response.data;
	    });
	}	
	init();
	
	$scope.updateLimit = function(limitation){		
		$http.post("http://localhost:9000/LMS/rule/limitUpdate", limitation).then(function(response){							
			console.log("update success");
		});			
	}
	
	$scope.cancel = function(){
		console.log("cancel");
		init();
	}
	
});