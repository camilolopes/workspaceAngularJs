'use strict';

angular.module('uiRouteMultipleViewApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ui.router'
])
.config(function($stateProvider,$locationProvider){
	//disable hashbang 
	//$locationProvider.html5Mode(true);
	
	$stateProvider
	.state('index',{
		url:"/", 
		views:{
			"viewA":{template:"home page"}
		}
	})
	.state('produtos',{
		url:"/product",
		views:{
			"viewA":{template:"content product.html"},
			"viewB":{template:"content product2.html"}
		}
	})
	
	.state('admin',{
		url:"/admin",
		views:{
			"admin.user":{templateUrl:"views/adminuser.html"},
			"admin.master":{templateUrl:"views/adminmaster.html"}
		}
	})
	.state('admincliente',{
		url:"/cliente/admin",
		views:{
			"admin.cliente":{templateUrl:"views/admincliente.html"}
		}
	})
});
