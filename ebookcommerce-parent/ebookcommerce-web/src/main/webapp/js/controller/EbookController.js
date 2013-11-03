var EbookController = function($scope, $location,EbookService) {

	$scope.listEbooks = EbookService.list();
	
	
};

EbookController.$inject = [ '$scope', '$location', 'EbookService' ];