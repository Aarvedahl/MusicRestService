angular.module('addsong', [])
  .controller('Addsong', function($scope, $http) {

    $http.get('http://localhost:8080/albums').
    then(function(response) {
      $scope.albums = response.data;
      console.log(response.data);
    });

    $scope.create = function(song) {
      console.log(song);
      $http({
          url: 'http://localhost:8080/songs/addSong',
          method: "POST",
          data: song,
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
          });
    };

  });