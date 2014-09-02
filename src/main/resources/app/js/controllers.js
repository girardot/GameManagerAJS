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
    controller('GameController', function ($scope, gameResource, gameStatusResource, $routeParams) {

        function getNextProgression(gameProgression) {
            var nextGameProgression = 'DONE'
            if (gameProgression == 'TO_DO') {
                nextGameProgression = 'IN_PROGRESS';
            }
            else if (gameProgression == 'IN_PROGRESS') {
                nextGameProgression = 'DONE';
            }
            else if (gameProgression == 'DONE') {
                nextGameProgression = 'TO_DO';
            }
            return nextGameProgression;
        }

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

        $scope.changeStatus = function (gameId, gameProgression) {
            var nextGameProgression = getNextProgression(gameProgression);
            gameStatusResource.save({consoleId: $routeParams.consoleId, gameId: gameId, status:nextGameProgression}, function (data) {
                refreshGames();
            });
        }

    })
;

