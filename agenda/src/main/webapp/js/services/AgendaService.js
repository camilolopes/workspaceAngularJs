$app.factory('AgendaService', [ '$resource', function($resource) {
	return $resource('rest/agenda/:id', {}, {
		
		create : {
			method : 'POST'
		},
		list : {
			method : 'GET',
			isArray : true
		},
		update :{
			method : "PUT"
		},
		remove :{
			method: "DELETE" 
		}
	}

	);

} ]);