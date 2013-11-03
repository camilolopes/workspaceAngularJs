$app.config(function($routeProvider,$httpProvider){
	
	$routeProvider.
	when ("/",{templateUrl:'view/home.html',controller:HomeController}).
	when ("/detailebook",{templateUrl:'view/ebook/detail.html',controller:HomeController}).
	when ("/meucarrinho",{templateUrl:'view/ebook/shop.html',controller:HomeController}).
	
	otherwise({
		redirectTo:'/'
	});
	$httpProvider.responseInterceptors.push(interceptor);
});