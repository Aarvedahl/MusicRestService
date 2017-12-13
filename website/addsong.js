angular.module('addsong', [])
  .controller('Addsong', function($scope, $http) {

    $http.get('http://localhost:8080/albums').
    then(function(response) {
      $scope.albums = response.data;
      console.log(response.data);
    });

    $scope.create = function(song) {
      console.log(song);
      /*    $http({
              url: 'URL',
              method: "POST",
              data: album,
              headers: {
                'Content-Type': 'application/json'
              }
            })
            .then(function(response) {
                // success
              },
              function(response) { // optional
                // failed
                console.error(response);
              }); */
    };

  });