var AgendaController = function($scope,AgendaService){
	
	//criamos um objeto do service restful, bem parecido com Java
	$scope.agenda = new AgendaService();
	
	//estamos invocando o serviço restful 
	$scope.listAgenda = AgendaService.list();
	
	$scope.reset = function(){
		$scope.agenda = new AgendaService();
	};
	
	//método que salva ou atualiza
	$scope.save = function(){
		if($scope.agenda.id > 0){
			$scope.update();
		}else{
			$scope.agenda.$create(function(){
				//depois que salvamos atualizamos a lista
				$scope.listAgenda = AgendaService.list();
				$scope.reset();
			});
		}
	};
	
	$scope.update = function(){
		$scope.agenda.$update(function(){
			$scope.listAgenda = AgendaService.list();
			$scope.reset();
		});
	};
	
	$scope.edit= function(agenda){
		$scope.agenda = agenda;
	};

};
//isso aqui pe dependency injection 
AgendaController.$inject=['$scope', 'AgendaService'];