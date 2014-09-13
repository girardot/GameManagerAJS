'use strict';

angular.module('gameManager.controllers', [])
    .controller('BiblioController', function ($scope, consoleResource, gameResource) {
        function refreshConsoles() {
            $scope.consoles = consoleResource.query();
        }

        refreshConsoles();

        function refreshGames(consoleId) {
            $scope.games = gameResource.query({consoleId: consoleId}, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var game = data[i];
                    fillPercentProgression(game);
                }
            });
        }

        refreshGames($scope.consoleId);

        $scope.displayGames = function (index) {
            var console = $scope.consoles[index];
            $scope.selectedConsoleId = console.id;


            refreshGames(console.id);
        }

    })
    .controller('ConsoleController', function ($scope, consoleResource) {

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
    })
    .controller('GameController', function ($scope, gameResource, gameStatusResource, gameDematerializeResource) {

        $scope.addGame = function () {
            gameResource.save({consoleId: $scope.selectedConsoleId, title: $scope.newGame}, function (data) {
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
            gameStatusResource.save({consoleId: $scope.selectedConsoleId, gameId: game.id, status: nextGameProgression}, function (data) {
                $scope.games[index] = fillPercentProgression(data);
            });
        }

        $scope.toogleDematerialize = function (index) {
            var game = $scope.games[index];

            gameDematerializeResource.save({consoleId: $scope.selectedConsoleId, gameId: game.id}, function (data) {
                $scope.games[index] = fillPercentProgression(data);
            });
        }

    })
;

