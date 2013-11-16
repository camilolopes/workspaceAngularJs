var AgendaController = function($scope,AgendaService){
	

	$scope.agenda = new AgendaService();
	
	//calling restful service
	$scope.listAgenda = AgendaService.list();
	
	$scope.reset = function(){
		$scope.agenda = new AgendaService();
	};
	
	//save or update
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
	
	$scope.remove = function(agenda){
		agenda.$remove({id:agenda.id},function(res){
			$scope.listAgenda = AgendaService.list();
		});
	};

};
//isso aqui pe dependency injection 
AgendaController.$inject=['$scope', 'AgendaService'];