var HomeController = function($scope, $rootScope, $location, EbookService, DataService) {

	$scope.listHomeEbooks = EbookService.list();

	 $scope.cart = DataService.cart;
	
	 
	$scope.detail = function(ebook){
		$rootScope.ebookSelected = ebook;	
		console.log($rootScope.ebookSelected);
		$location.path("/detailebook");
	};
	
	$scope.goHome = function(){
		$location.path("#/");
	};

};//end of homecontroller


HomeController.$inject = [ '$scope', '$rootScope', '$location', 'EbookService','DataService'];
