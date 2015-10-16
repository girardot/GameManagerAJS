'use strict';

angular.module('gameManager.authenticationControllers', [])
    .controller('AuthenticationController', function ($scope, $rootScope, $location, $http) {

        $scope.login = function (credentials) {

            $http.post('/services/authentication', {'email': credentials.email, 'password': credentials.password})
                .success(function (user) {
                    $rootScope.connectedUser = {
                        'firstname': user.firstname,
                        'lastname': user.lastname,
                        'email': user.email
                    };
                    $location.path('/biblio');
                })
                .error(function () {
                    $scope.loginError = "Authentication error for :" + credentials.email;
                    $location.path('/signIn');
                });
        };

        $rootScope.signOut = function() {
            $http.post('/services/signOut')
                .success(function () {
                    $rootScope.connectedUser = {};
                    $location.path('/signIn');
                });
        };
    })
;