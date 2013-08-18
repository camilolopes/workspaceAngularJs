var movieController = function($scope, $resource, $location) {
	$scope.movie = null;
	$scope.count = 2;

	$scope.counterVote = 0;
	var Movies = $resource("rest/movie/");
	var topMovie = $resource("rest/movie/top");
	
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
//		TODO resource for save user here 
		$location.path("/topmovie")
	};

};//end movieController