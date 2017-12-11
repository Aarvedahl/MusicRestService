angular.module('favorite', [])
  .controller('Favorites', function($scope, $http) {
    $http.get('http://localhost:8080/albums/showFavorites').
    then(function(response) {
      $scope.songs = response.data;
    });

  });