$app.config(function($routeProvider, $httpProvider) {

	$routeProvider.
	when("/",{templateUrl : "view/home.html",controller : AgendaController
	});

	$httpProvider.responseInterceptors.push(interceptor);

});