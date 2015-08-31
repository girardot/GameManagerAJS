'use strict';

angular.module('gameManager.authenticationControllers', [])
    .controller('AuthenticationController', function ($scope, $location, $http) {

        $scope.login = function (credentials) {

            $http.post('/services/authentication', {'email': credentials.email, 'password': credentials.password})
                .success(function (user) {
//                    Auth.setUser(user);
                    $location.path('/biblio');
                })
                .error(function (data) {
                    $scope.loginError = data.loginError;
                    $location.path('/signIn');
                });
        }
    })
;