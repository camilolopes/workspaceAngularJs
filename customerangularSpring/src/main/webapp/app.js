	$app = angular.module('app',['ngResource']);
	
	$app.config(function($routeProvider,$httpProvider,$locationProvider){
				//routes
		$routeProvider.
		when('/',{templateUrl:'view/customers.html',controller:customerController}).
		when('/create',{templateUrl:'view/form.html',controller:customerController}).
		when('/list',{templateUrl:'view/customers.html',controller:customerController}).
		otherwise(
				{
					redirectTo:'/'
				});
		

	$httpProvider.responseInterceptors.push(function($q,$rootScope){
		return function(promise){
			return promise.then(function(response){
				return (response);
			},function(response){
				$data = response.data;
				$error = $data.error;
				if($error && $error.text){
					console.log("ERROR: " + $error.text);
				}
				else{
					if(response.status=404)
					console.log("page not found");
				}
				return $q.reject(response);
			});
		};
	});
});
	


			
	
