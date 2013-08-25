$app.config(['$translateProvider', function ($translateProvider) {
  $translateProvider.translations('en', {
    'label.question.movie': 'What is your favorite movie?',
    'label.title': 'Vote in Movie?',
    'label.vote': 'Vote',
    'label.startVote':'Starting vote',
    'msg.vote':'Your register and vote were recorded with success',
    'msg.most.movie':'The most voted movie',
    'label.name.movie':'Name of the Movie',
    'label.total.vote':'Total Vote',
    'msg.register':'Register for confirmation the votes',
    'msg.required.field':'* fields are required',
    'label.name':'Name *',
    'label.register':'Register',
    'msg.finalize.vote':'Please, finish the vote',
    'label.finish.vote':'Finish Vote'
    
  });
 
  $translateProvider.translations('pt', {
    'label.question.movie': 'Qual filme você gosta mais?',
    'label.title': 'Vote no Filme',
    'label.vote': 'Votar',
    'label.startVote':'Iniciar nova votação',
    'msg.vote':'Seu registro e seu voto foram  registrados com sucesso',
    'msg.most.movie':'Veja os filmes mais votados',
    'label.name.movie':'Nome do Filme',
    'label.total.vote':'Total de Votos',
    'msg.register':'Faça seu registro para confirmação dos votos',
    'msg.required.field':'Os campos * são requeridos',
    'label.name':'Nome *',
    'label.register':'Registrar',
    'msg.finalize.vote':'Por favor, finalize a votação',
    'label.finish.vote':'Finalizar Votação'
    
  });
 
  $translateProvider.preferredLanguage('en');
}]);