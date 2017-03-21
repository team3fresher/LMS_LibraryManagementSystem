var app = angular.module('myAdmin');


app.controller('AdminReportController', function($http, $scope, $routeParams) {
		
	var dataReportByTicket = [];
	var dataReportByIncome= [];
	$scope.ticketReport = [];
	$scope.incomeReport = [];
	
	$scope.ticketData = {
		     ticketModel: 'ticketReportByWeek',
		     ticketOptions: [
		       {id: 'ticketReportByWeek', name: 'Weekly'},
		       {id: 'ticketReportByMonth', name: 'Monthly'},
		       {id: 'ticketReportByYear', name: 'Yearly'}
		     ]
		    };
	$scope.incomeData = {
		     incomeModel: 'incomeReportByMonth',
		     incomeOptions: [		       
		       {id: 'incomeReportByMonth', name: 'Monthly'},
		       {id: 'incomeReportByYear', name: 'Yearly'}
		     ]
		    };
			
	//start get report by ticket
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/ticket/report"
	}).success(function(data, status, headers, config){			
		dataReportByTicket= data;		
		$scope.ticketReport = dataReportByTicket.reportByWeek;
	})
	.error(function(data, status, headers, config){});
		
 	$scope.changeTicketReportType = function(){
 		var type = $scope.ticketData.ticketModel; 		
 		if(angular.equals(type, "ticketReportByMonth")) {
 			$scope.ticketReport = dataReportByTicket.reportByMonth;
 		}else if(angular.equals(type, "ticketReportByWeek")){
 			$scope.ticketReport = dataReportByTicket.reportByWeek;
 		}else if(angular.equals(type, "ticketReportByYear")){
 			$scope.ticketReport = dataReportByTicket.reportByYear;
 		}
 	}
 	//end get report by ticket
 	
 	
 	//start get report by income
	$http({
		method: 'get',
		url: "http://localhost:9000/LMS/payment/report"
	}).success(function(data, status, headers, config){			
		dataReportByIncome = data;		
		$scope.incomeReport = dataReportByIncome.reportByMonth;
	})
	.error(function(data, status, headers, config){});
 	
 	$scope.changeIncomeReportType = function(){ 		
 		var type = $scope.incomeData.incomeModel; 		
 		if(angular.equals(type, "incomeReportByMonth")) {
 			$scope.incomeReport = dataReportByIncome.reportByMonth;
 		}else if(angular.equals(type, "incomeReportByYear")){
 			$scope.incomeReport = dataReportByIncome.reportByYear;
 		}
 	}
});