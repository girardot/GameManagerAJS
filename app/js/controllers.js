//'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, $http) {
        $http.get('consoles/consoles.json').success(function (data) {
            $scope.consoles = data;
        });
    }).
    controller('GameController', function ($scope, $http, $routeParams) {
        $http.get("consoles/"+$routeParams.consoleId+"Games.json").success(function (data) {
            $scope.games = data;
        });
    })
;
