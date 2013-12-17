//'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, $http) {
        $http.get('consoles/consoles.json').success(function (data) {
            $scope.consoles = data;
        });

        $scope.addConsole = function() {
            alert('call web service to add a new console : ' + $scope.newConsole);
            $scope.consoles.push({"id":4, "name":$scope.newConsole});
        }

    }).
    controller('GameController', function ($scope, $http, $routeParams) {
        $http.get("consoles/"+$routeParams.consoleId+"Games.json").success(function (data) {
            $scope.games = data;
        });

        $scope.addGame = function() {
            alert('call web service to add a new game : ' + $scope.newGame);
            $scope.games.push({"title":$scope.newGame});
        }

    })
;
