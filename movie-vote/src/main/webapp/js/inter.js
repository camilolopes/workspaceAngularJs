$app.config(['$translateProvider', function ($translateProvider) {
  $translateProvider.translations('en', {
    'label.question.movie': 'What is your favorite movie?',
    'label.title': 'Vote in Movie?'
    
  });
 
  $translateProvider.translations('pt', {
    'label.question.movie': 'Qual filme você gosta mais?',
    'label.title': 'Vote no Filme'
    
  });
 
  $translateProvider.preferredLanguage('en');
}]);