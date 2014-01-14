'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, consoleResource) {

        $scope.consoles = consoleResource.query();

        $scope.addConsole = function () {
            consoleResource.save($scope.newConsole, function (data) {
                $scope.consoles.push(data);
            });
        }

        $scope.removeConsole = function (consoleId) {
            consoleResource.remove({consoleId: consoleId}, function (data) {
                alert($scope.consoles.indexOf(data));
                $scope.consoles.splice($scope.consoles.indexOf(data), 1);
            });
        }
    }).
    controller('GameController', function ($scope, gameResource, $routeParams) {
        $scope.games = gameResource.query({consoleId: $routeParams.consoleId});

        $scope.addGame = function () {
            gameResource.save({consoleId: $routeParams.consoleId, title: $scope.newGame}, function (data) {
                $scope.games.push(data);
            });
        }

        $scope.removeGame = function (gameId) {
            gameResource.remove({gameId: gameId}, function (data) {
                $scope.games.splice($scope.games.indexOf(data), 1);
            });
        }

    })
;

