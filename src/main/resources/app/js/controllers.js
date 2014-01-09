'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, consoleResource) {

        $scope.consoles = consoleResource.query();

        $scope.addConsole = function() {
            consoleResource.save($scope.newConsole, function(data) {
                $scope.consoles.push(data);
            });
        }

    }).
    controller('GameController', function ($scope, gameResource, $routeParams) {
        $scope.games = gameResource.query({consoleId: $routeParams.consoleId});

        $scope.addGame = function() {
            gameResource.save($scope.newGame, function(data) {
                $scope.games.push(data);
            });
        }

    })
;
