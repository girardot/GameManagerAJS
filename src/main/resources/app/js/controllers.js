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
                console.log("saveCallback data :");
                console.log(data);
                refreshConsoles();
            });
        };

        $scope.displayRemoveConsoleModal = function (index) {
            var console = $scope.consoles[index];

            openModalDeletion('Console', console.name);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                consoleResource.remove({consoleId: console.id}, function () {
                    refreshConsoles();
                });
            });

        }
    }).
    controller('GameController', function ($scope, gameResource, gameStatusResource, $routeParams) {

        function refreshGames() {
            $scope.games = gameResource.query({consoleId: $routeParams.consoleId});
        }

        refreshGames();

        $scope.addGame = function () {
            gameResource.save({consoleId: $routeParams.consoleId, title: $scope.newGame}, function (data) {
                refreshGames();
            });
        };

        $scope.displayRemoveGameModal = function (index) {
            var game = $scope.games[index];

            openModalDeletion('Game', game.title);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                gameResource.remove({gameId: game.id}, function () {
                    refreshGames();
                });
            });
        }

        $scope.changeStatus = function (gameId, gameProgression) {
            var nextGameProgression = getNextProgression(gameProgression);
            gameStatusResource.save({consoleId: $routeParams.consoleId, gameId: gameId, status: nextGameProgression}, function (data) {
                refreshGames();
            });
        }

    })
;

