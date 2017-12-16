angular.module('addalbum', [])
  .controller('Addalbum', function($scope, $http) {

    $scope.create = function(album) {
      album.songs = [];
      console.log(album);
      $http({
          url: 'http://localhost:8080/albums/addAlbum',
          method: "POST",
          data: album,
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(function(response) {
            // success
            $scope.failed = false;
            $scope.success = true;
          },
          function(response) {
            // failed
            $scope.success = false;
            $scope.failed = true;
            console.error(response);
          });
    };

  });