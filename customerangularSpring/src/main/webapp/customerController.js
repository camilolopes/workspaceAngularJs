function customerController($scope,$http,$routeParams,$location){
	$scope.rows=null;
	$scope.row=null;
	

$scope.loadAll = function(){
/*	esse é o cara que chama o service rest
 * Observe que ele concatena o valor com o que foi definido na variavel SERVER
 */ 
	$http.get($scope.server("/service/")).success(function(data){
		$scope.rows=data;
		alert("loadALL");
	}).error(function(data){
		alert("Error...");
		console.log(data);
	});
};

//$scope.loadRow = function(){
//	if($routeParams.id!=null){
//		
//		$scope.showLoader();
//		$http.get($scope.server("/client"+$routeParams.id)).sucess(function(data){
//				$scope.row=data;
//				$scope.row.isUpdate=true;
//	});
//	}
//	else{
//		$scope.row=[];
//		$scope.row.id=null;
//		$scope.row.isUpdate=false;
//	}
//};
}