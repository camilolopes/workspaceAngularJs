var recipeController = function($scope, UserService) {
	$scope.name = "";
	$scope.users = UserService.all();

	$scope.countries = [
	{name:'Brazil'},
	{name:'Australia'},
	{name:'Canadá'}
	]
	
	$scope.$watch("name", function(newValue, oldValue) {
		if ($scope.name.length > 0) {
			$scope.greeting = "Greeting " + $scope.name;
		}
	});

	$scope.send = function($scope){
		alert("send");
	}
	//check if field passed is valid or invalid 
	$scope.getCssClasses = function(ngModelController){
		return{
			error:ngModelController.$invalid && ngModelController.$dirty,
			success:ngModelController.$valid && ngModelController.$dirty
		};
	};
	$scope.showError = function(ngModelController,error){
		return ngModelController.$error[error];
	};

};
recipeController.$inject = [ "$scope", "UserService" ];

var anotherController = function($scope, UserService) {
	$scope.firstUser = UserService.first();
};
anotherController.$inject = [ "$scope", "UserService" ];

var blacklistController = function($scope) {
	// criando meu black list, um array.
	$scope.blacklist = [ 'satanas', 'biba' ];
	// verifica se a palavra digitada corresponde ao que temos no blacklist
	$scope.notBlackListed = function(value) {
		return $scope.blacklist.indexOf(value) === -1;
	};
};

var filterController = function($scope) {
	$scope.friends = [ {
		name : "Camilo",
		lastname:"Lopes",
		age : 20
	}, {
		name : "Chapolin",
		lastname:"Santana",
		age : 55
	}, {
		name : "Madruga",
		lastname:"Santos",
		age : 60
	}, {
		name : "Ana",
		lastname:"Lopes",
		age : 30
	},
	{
		name : "Zenilton",
		lastname:"Alves",
		age : 30
	}

	 ];

	  $scope.sortField = undefined;
      $scope.reverse = false;

	 $scope.isSortUp = function(fieldName){
	 	return $scope.sortField === fieldName && !$scope.reverse;
	 };
	 $scope.isSortDown = function(fieldName){
	 	return $scope.sortField === fieldName && $scope.reverse;
	 };
	 //order data
	 $scope.sort = function(fieldName){
	 	if ($scope.sortField === fieldName) {
	 		$scope.reverse = !$scope.reverse;
	 	}else{
	 		$scope.sortField = fieldName;
	 		$scope.reverse = false;

	 	};
	 }

	  

};

var PaginationCtrl = function($scope) {
	$scope.itemsPerPage = 5;
	$scope.currentPage = 0;
	$scope.items = [];

	for ( var i = 0; i < 50; i++) {
		$scope.items.push({
			id : i,
			name : "name " + i,
			description : "description " + i
		});
	}
	$scope.range = function() {
		var rangeSize = 5;
		var ret = [];
		var start;

		start = $scope.currentPage;
		if (start > $scope.pageCount() - rangeSize) {
			start = $scope.pageCount() - rangeSize + 1;
		}

		for ( var i = start; i < start + rangeSize; i++) {
			ret.push(i);
		}
		return ret;
	};
	$scope.prevPage = function() {
		if ($scope.currentPage > 0) {
			$scope.currentPage--;
		}
	};
	$scope.prevPageDisabled = function() {
		return $scope.currentPage === 0 ? "disabled" : "";
	};
	$scope.pageCount = function() {
		return Math.ceil($scope.items.length / $scope.itemsPerPage) - 1;
	};
	$scope.nextPage = function() {
		if ($scope.currentPage < $scope.pageCount()) {
			$scope.currentPage++;
		}
	};
	$scope.nextPageDisabled = function() {
		return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
	};
};// end of paginaiton controller

var PaginationCtrl2 = function($scope, Item) {
	$scope.itemsPerPage = 5;
	$scope.currentPage = 0;

	$scope.range = function() {
		var rangeSize = 5;
		var ret = [];
		var start;

		start = $scope.currentPage;
		if (start > $scope.pageCount() - rangeSize) {
			start = $scope.pageCount() - rangeSize + 1;
		}

		for ( var i = start; i < start + rangeSize; i++) {
			ret.push(i);
		}
		return ret;
	};
	$scope.prevPage = function() {
		if ($scope.currentPage > 0) {
			$scope.currentPage--;
		}
	};
	$scope.prevPageDisabled = function() {
		return $scope.currentPage === 0 ? "disabled" : "";
	};
	$scope.pageCount = function() {
		return Math.ceil($scope.total / $scope.itemsPerPage);
	};
	$scope.nextPage = function() {
		if ($scope.currentPage < $scope.pageCount()) {
			$scope.currentPage++;
		}
	};

	$scope.setPage = function(n) {
		if (n > 0 && n < $scope.pageCount()) {
			$scope.currentPage = n;
		}
	};
	$scope.nextPageDisabled = function() {
		return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
	};
	$scope.$watch("currentPage", function(newValue, oldValue) {
		$scope.pagedItems = Item.get(newValue * $scope.itemsPerPage,
				$scope.itemsPerPage);
		$scope.total = Item.total;
	});
};

var MyCtrlDialog = function($scope) {
	$scope.open = function() {
		$scope.showModal = true;
	};

	$scope.ok = function() {
		$scope.showModal = false;
	};

	$scope.cancel = function() {
		$scope.showModal = false;
	};
};
