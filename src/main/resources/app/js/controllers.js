'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, consoleResource) {

        function refreshConsoles() {
            $scope.consoles = consoleResource.query();
        }

        refreshConsoles();

        $scope.addConsole = function () {
            console.log("addConsole");
            consoleResource.save($scope.newConsole, function (data) {
                console.log("saveCallback data :" );
                console.log(data);
                refreshConsoles();
            });
        };

        $scope.removeConsole = function (consoleId) {
            consoleResource.remove({consoleId: consoleId}, function (data) {
                refreshConsoles();
            });
        }
    }).
    controller('GameController', function ($scope, gameResource, $routeParams) {
        function refreshGames() {
            $scope.games = gameResource.query({consoleId: $routeParams.consoleId});
        }

        refreshGames();

        $scope.addGame = function () {
            gameResource.save({consoleId: $routeParams.consoleId, title: $scope.newGame}, function (data) {
                refreshGames();
            });
        };

        $scope.removeGame = function (gameId) {
            gameResource.remove({gameId: gameId}, function (data) {
                refreshGames();
            });
        }

    })
;

