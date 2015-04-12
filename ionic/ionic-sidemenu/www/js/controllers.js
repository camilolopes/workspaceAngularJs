angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout) {
  // Form data for the login modal
  $scope.loginData = {};

  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/login.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeLogin = function() {
    $scope.modal.hide();
  };

  // Open the login modal
  $scope.login = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doLogin = function() {
    console.log('Doing login', $scope.loginData);

    // Simulate a login delay. Remove this and replace with your login
    // code if using a login system
    $timeout(function() {
      $scope.closeLogin();
    }, 1000);
  };
})

.controller('PlaylistsCtrl', function($scope) {
  $scope.playlists = [
    
    { title: 'Recarga Celular', id: 1 },
    { title: 'Extrato Conta', id: 2 },
    { title: 'Realizar Saque', id: 3 }
    
  ];
})

.controller('MainCtrl', function($scope, $http) {
  $scope.teste='usecash mobile'
 $http.get('url api web service').then(function(resp) {
    console.log('Success', resp);
    $scope.teste = resp;
  }, function(err) {
    console.error('ERR', err);
    // err.status will contain the status code
  })
})

.controller('PlaylistCtrl', function($scope, $stateParams) {
});
