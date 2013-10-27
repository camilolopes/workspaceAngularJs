var recipeController = function($scope, UserService) {
	$scope.name = "";
	$scope.users = UserService.all();

	$scope.$watch("name", function(newValue, oldValue) {
		if ($scope.name.length > 0) {
			$scope.greeting = "Greeting " + $scope.name;
		}
	});

};
recipeController.$inject = [ "$scope", "UserService" ];

var anotherController = function($scope, UserService) {
	$scope.firstUser = UserService.first();
};
anotherController.$inject = [ "$scope", "UserService" ];

var blacklistController = function($scope) {
	//criando meu black list, um array. 
	$scope.blacklist = [ 'satanas', 'biba' ];
	//verifica se a palavra digitada corresponde ao que temos no blacklist
	$scope.notBlackListed = function(value) {
		return $scope.blacklist.indexOf(value) === -1;
	};
};

var filterController = function($scope) {
	$scope.friends = [ {
		name : "Camilo",
		age : 20
	}, {
		name : "Lopes",
		age : 55
	}, {
		name : "Madruga",
		age : 60
	}, {
		name : "Ana",
		age : 30
	} ];
};