'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
    controller('ConsoleController',function ($scope, consoleResource) {

        function refreshConsoles() {
            $scope.consoles = consoleResource.query();
        }

        refreshConsoles();

        $scope.addConsole = function () {
            consoleResource.save($scope.newConsole, function (data) {
                $scope.consoles.push(data);
            });
        };

        $scope.displayRemoveConsoleModal = function (index) {
            var console = $scope.consoles[index];

            openModalDeletion('Console', console.name);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                consoleResource.remove({consoleId: console.id}, function () {
                    $scope.consoles.splice(index, 1);
                });
            });

        }
    }).
    controller('GameController', function ($scope, gameResource, gameStatusResource, gameDematerializeResource, $routeParams) {

        function refreshGames() {
            $scope.games = gameResource.query({consoleId: $routeParams.consoleId}, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var game = data[i];
                    fillPercentProgression(game);
                }
            });
        }

        refreshGames();

        $scope.addGame = function () {
            gameResource.save({consoleId: $routeParams.consoleId, title: $scope.newGame}, function (data) {
                $scope.games.push(fillPercentProgression(data));
            });
        };

        $scope.displayRemoveGameModal = function (index) {
            var game = $scope.games[index];

            openModalDeletion('Game', game.title);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                gameResource.remove({gameId: game.id}, function () {
                    $scope.games.splice(index, 1);
                });
            });
        }

        $scope.changeStatus = function (index, gameProgression) {
            var game = $scope.games[index];
            var nextGameProgression = getNextProgression(gameProgression);
            gameStatusResource.save({consoleId: $routeParams.consoleId, gameId: game.id, status: nextGameProgression}, function (data) {
                $scope.games[index] = fillPercentProgression(data);
            });
        }

        $scope.toogleDematerialize = function (index) {
            var game = $scope.games[index];

            gameDematerializeResource.save({consoleId: $routeParams.consoleId, gameId: game.id}, function (data) {
                $scope.games[index] = fillPercentProgression(data);
            });
        }

    })
;

