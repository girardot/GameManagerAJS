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

        $scope.displayRemoveConsoleModal = function (consoleId) {

            $('#consoleModalDeletion').modal({
                keyboard: true
            });

            $('#consoleModalDeletionNo').unbind("click").on('click', function () {
                $('#consoleModalDeletion').modal('hide');
            });

            $('#consoleModalDeletionYes').unbind("click").on('click', function () {
                $('#consoleModalDeletion').modal('hide');
                consoleResource.remove({consoleId: consoleId}, function () {
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

        $scope.displayRemoveGameModal = function (gameId) {
            $('#consoleModalDeletion').modal({
                keyboard: true
            });

            $('#consoleModalDeletionNo').unbind("click").on('click', function () {
                $('#consoleModalDeletion').modal('hide');
            });

            $('#consoleModalDeletionYes').unbind("click").on('click', function () {
                $('#consoleModalDeletion').modal('hide');
                gameResource.remove({gameId: gameId}, function () {
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

