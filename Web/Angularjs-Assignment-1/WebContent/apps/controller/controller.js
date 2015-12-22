module.controller('customermanagement', function($scope) {

	// default view is list
	$scope.mode = 1;
	$scope.isSuccessful = false;
	$scope.showMessage = false;
		$scope.customers = [];

		$scope.newcustomer = function() {
			if(typeof $scope.customer == 'undefined' ||typeof $scope.customer.fname == 'undefined' 
			   || typeof $scope.customer.lname == 'undefined' || typeof $scope.customer.email == 'undefined'
			   || typeof $scope.customer.address == 'undefined'|| typeof $scope.customer.orders == 'undefined') {
					$scope.isSuccessful = false;
					$scope.messageCode = "Error !!";
					$scope.message = "Error While Entering the Data";
					$scope.showMessage = true;
					return false;
			}
			$scope.customers.push($scope.customer);
			$scope.isSuccessful = true;
			$scope.messageCode = "Success !!";
			$scope.message = "Data Entered Successfully";
			$scope.showMessage = true;
			$scope.customer = null;
			
		}
		$scope.deletecustomer = function(index) {
			$scope.detail = $scope.customers[index];
			$scope.customers.splice(index, 1);
		}
		
		$scope.filtering = function(customer) {
			fullname = customer.fname+' '+customer.lname;
			if(fullname.indexOf($scope.searchFilter) != -1) return true;
			return false;
		}
		
		$scope.setDetails = function(customer) {
		$scope.detail = customer;
		}
		
});
