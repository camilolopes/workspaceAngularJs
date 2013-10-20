
function customerController($scope,$resource,$location){
	
	$scope.row=null;
	Customer = $resource("rest/service/");
	
$scope.loadAll = function(){
	Customer.query(
			function(data){
				$scope.rows = data;
		
	});
}; 

	$scope.newOne = function() {

		var c = new Customer();
		c.name = $scope.nameCustomer;
		c.$save();

	};
}