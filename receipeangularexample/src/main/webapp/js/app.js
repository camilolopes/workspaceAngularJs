var app = angular.module("myapp",["ui","ui.directives"]);

//creating route
app.config(function($routeProvider,$httpProvider,$locationProvider){
	$routeProvider.
	when("/",{templateUrl:"home.html"}).
	when("/upper",{templateUrl:"upperfilter.html"}).
	when("/serviceioc",{templateUrl:"serviceioc.html"}).
	when("/checkme",{templateUrl:"checkme.html"}).
	when("/locale",{templateUrl:"locale.html"}).
	when("/angularui",{templateUrl:"angularui.html",controller:blacklistController}).
	when("/filtername",{templateUrl:"filterorder.html",controller:filterController}).
	when("/watch",{templateUrl:"watch.html",controller:recipeController});
	
});
//creating my service
app.factory("UserService",function(){
	var users = ["Ivete", "Camilo", "Lopes"];
	
	return{
		all:function(){
			return users;
		},
		first:function(){
			return users[0];
		}
	};
});


//creating directive name
app.directive("show",function(){
	return{
		link:function(scope,element,attributes){
			scope.$watch(attributes.show,function(value){
				element.css('display',value ? '':'none');
			});
		}
	};
});