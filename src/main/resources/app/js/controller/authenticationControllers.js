'use strict';

angular.module('gameManager.authenticationControllers', [])
    .controller('AuthenticationController', function ($scope) {

        $scope.login = function() {
            alert('login with ' + $scope.email + 'password' + $scope.password) ;
        }

    })
;