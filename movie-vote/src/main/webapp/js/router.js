$app.config(function($routeProvider,$httpProvider){
	$routeProvider.
	when("/",{templateUrl:'view/votemovie.html',controller:movieController}).
	when("/confirmvote",{templateUrl:'view/confirmvote.html',controller:movieController}) .
	when("/registeruser",{templateUrl:'view/form.html',controller:movieController}) .
	when("/topmovie",{templateUrl:'view/topmovie.html',controller:movieController})	;
	$httpProvider.responseInterceptors.push(interceptor);
	

});