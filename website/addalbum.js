angular.module('addalbum', [])
  .controller('Addalbum', function($scope, $http) {

    $scope.create = function(album) {
      album.songs = [];
      console.log(album);
      //  $scope.master = angular.copy(user);
    };

  });