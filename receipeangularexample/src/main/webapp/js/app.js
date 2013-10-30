var app = angular.module("myapp", [ "ui", "ui.directives","ui.bootstrap.modal" ]);


// creating route
app.config(function($routeProvider, $httpProvider, $locationProvider) {
	$routeProvider.when("/", {
		templateUrl : "home.html"
	}).when("/upper", {
		templateUrl : "upperfilter.html"
	}).when("/serviceioc", {
		templateUrl : "serviceioc.html"
	}).when("/checkme", {
		templateUrl : "checkme.html"
	}).when("/locale", {
		templateUrl : "locale.html"
	}).when("/angularui", {
		templateUrl : "angularui.html",
		controller : blacklistController
	}).when("/filtername", {
		templateUrl : "filterorder.html",
		controller : filterController
	}).when("/paginating", {
		templateUrl : "paginating.html",
		controller : PaginationCtrl
	}).when("/paginating2", {
		templateUrl : "paginating2.html",
		controller : PaginationCtrl2
	}).
	when("/editavel", {
		templateUrl : "editavel.html"
	}).
	when("/dialog", {
		templateUrl : "dialog.html",controller:MyCtrlDialog 
	}).
	when("/watch", {
		templateUrl : "watch.html",
		controller : recipeController
	});

});
// creating my service
app.factory("UserService", function() {
	var users = [ "Ivete", "Camilo", "Lopes" ];

	return {
		all : function() {
			return users;
		},
		first : function() {
			return users[0];
		}
	};
});


//creating Item service for pagination
app.factory("Item", function() {
	var items = [ {
		name : "Kent Beck",
		description : "developer"
	}, {
		name : "Camilo",
		description : "Developer"
	},
	{
		name : "Jobs",
		description : "CEO"
	},
	];

	for ( var i = 0; i < 50; i++) {
		items.push({
			id : i,
			name : "name " + i,
			description : "description " + i
		});
	}
	return {
		get : function(offset, limit) {
			return items.slice(offset, offset + limit);
		},
		total : function() {
			return items.length;
		}
	};
});

// creating directive name
app.directive("show", function() {
	return {
		link : function(scope, element, attributes) {
			scope.$watch(attributes.show, function(value) {
				element.css('display', value ? '' : 'none');
			});
		}
	};
});

//criando campo editavel
app.directive("contenteditable",function(){
	return {
		restrict:"A",
		require: "ngModel",
		link:function(scope,element, attrs, ngModel){
			//notifica o angular sobre a mudança
			function read(){
				ngModel.$setViewValue(element.html());
			}
			
			ngModel.$render = function(){
				element.html(ngModel.$viewValue|| "");
			};
			element.bind("blur keyup change", function(){
				scope.$apply(read);
			});
		}
	};
	
});