angular.module('demo', [])
  .controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/albums').
    then(function(response) {
      $scope.albums = response.data;
    });


    $scope.foo = function($event, album) {
      console.log($event);
    }

  });