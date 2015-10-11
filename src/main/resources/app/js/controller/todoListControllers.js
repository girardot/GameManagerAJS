'use strict';

angular.module('gameManager.todoListControllers', [])
    .controller('TodoListController', function ($scope, gameToDoResource, gameStatusResource) {
        function refeshGameToBuyList() {
            $scope.todoList = gameToDoResource.query();
        }

        refeshGameToBuyList();

        $scope.startToPlay = function (index) {

            var game = $scope.todoList[index];

            openModalStartToPlay(game.title);

            $('#modalStartToPlayButtonYes').unbind("click").on('click', function () {
                closeModalStartToPlay();
                var nextGameProgression = getNextProgression(gameProgression);
                // TODO sans le gameID
                // gameStatusResource.save({consoleId: $scope.selectedConsoleId, gameId: game.id, status: nextGameProgression}, function (data) {
                //  $scope.games.splice(index, 1);
                //});
            });

        };

    })
;

