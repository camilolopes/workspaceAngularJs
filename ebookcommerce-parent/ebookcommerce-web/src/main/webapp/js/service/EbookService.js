$app.factory('EbookService', ['$resource',function($resource) {

    return $resource(baseUriRoot + '/ebook/', { },
    		{
    	list: {method: 'GET', isArray : true},
    	

    });
}]);