angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/albums/getOneAlbum').
        then(function(response) {
            console.log(response.data);
            $scope.album = response.data;
        });


});
