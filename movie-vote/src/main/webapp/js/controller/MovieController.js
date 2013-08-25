
var movieController = function($scope, $resource, $location,$window) {
	$scope.movie = null;
	$scope.count = 2;

	$scope.counterVote = 0;
	var Movies = $resource("rest/movie/");
	var topMovie = $resource("rest/movie/top");
	var User = $resource("rest/movie/vote/finish");
	
	$scope.loadAllMovies = function() {
		Movies.query(function(data) {
			$scope.listMovies = data;
			
		});

	};//end loadAllMovies
	
	$scope.loadTopMovies = function(){
		topMovie.query(function(data){
			$scope.listTopMovies = data;
			
		});
	};

	$scope.votar = function(movie) {
		var mov = new Movies();
		mov = movie;
		mov.$save();
		$scope.count = -2;
		$scope.counterVote++;
		if ($scope.counterVote == 2) {
			$location.path("/confirmvote");
		}

	};

	$scope.confirmRegister = function() {
		$location.path("/registeruser");

	};
	
	$scope.registerUser = function(){
		var u = new User();
		u.name = $scope.user.name;
		u.email = $scope.user.email;
		u.$save();
		$window.location.href="#/topmovie";
		
	};
	$scope.newVote = function(){
		$location.path("/");
	};

};//end movieController
$.ajaxSetup ({
	   // Disable caching of AJAX responses
	    cache: false
});
