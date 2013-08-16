//function customerController($scope,$http,$routeParams,$location){
function customerController($scope,$resource){
	
	$scope.row=null;
	Customer = $resource("rest/service/");
	
$scope.loadAll = function(){
/*	esse é o cara que chama o service rest
 * Observe que ele concatena o valor com o que foi definido na variavel SERVER
 */ 
//	$http.get($scope.server("/service/")).success(function(data){
//		$scope.rows=data;
////		alert("loadALL");
//	}).error(function(data){
////		alert("Error...");
//		console.log(data);
//	});
	
	Customer.query(
			function(data){
				$scope.rows = data;
		
	});
}; //end loadAll

$scope.newOne = function(){
//	$http.post($scope.server("/service/",data)).success(successCallback);
var c = new Customer();
c.name = $scope.nameCustomer;
c.$save();
};
}