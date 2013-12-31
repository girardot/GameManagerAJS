'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, consoleResource) {

        $scope.consoles = consoleResource.query();

        $scope.addConsole = function() {
            alert('call web service to add a new console : ' + $scope.newConsole);
            $scope.consoles.push({"id":4, "name":$scope.newConsole});
        }

    }).
    controller('GameController', function ($scope, gameResource, $routeParams) {
        $scope.games = gameResource.query({consoleId: $routeParams.consoleId});

        $scope.addGame = function() {
            alert('call web service to add a new game : ' + $scope.newGame);
            $scope.games.push({"title":$scope.newGame});
        }

    })
;
