$app.factory('AgendaService', [ '$resource', function($resource) {
	return $resource('rest/agenda/', {}, {
		
		create : {
			method : 'POST'
		},
		list : {
			method : 'GET',
			isArray : true
		}
	}

	);

} ]);