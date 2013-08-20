
var interceptor = function($rootScope, $q, $location) {

	function success(response) {
		return response;
	}

	function error(response) {

		var status = response.status;
		var config = response.config;
		var method = config.method;
		var url = config.url;

		if (status == 401) {
			$location.path("/");
		} else {
			$rootScope.error = method + " on " + url + " failed with status " + status;
		}

		return $q.reject(response);
	}

	return function(promise) {
		return promise.then(success, error);
	};

};

interceptor.$inject = ['$rootScope', '$q', '$location'];
$.ajaxSetup ({
    // Disable caching of AJAX responses
    cache: false
});