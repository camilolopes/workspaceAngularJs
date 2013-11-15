var AgendaController = function($scope,AgendaService){
	
	//criamos um objeto do service restful, bem parecido com Java
	$scope.agenda = new AgendaService();
	
	//estamos invocando o serviço restful 
	$scope.listAgenda = AgendaService.list();
	
	//método que salva 
	$scope.save = function(){
		$scope.agenda.$create(function(){
			//depois que salvamos atualizamos a lista
			$scope.listAgenda = AgendaService.list();
		});
	};
};
//isso aqui pe dependency injection 
AgendaController.$inject=['$scope', 'AgendaService'];