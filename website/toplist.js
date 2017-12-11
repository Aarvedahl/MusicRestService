angular.module('toplist', [])
  .controller('TopList', function($scope, $http) {
    $http.get('http://localhost:8080/albums/sortOnRating').
    then(function(response) {
      $scope.songs = response.data;
    });

  });