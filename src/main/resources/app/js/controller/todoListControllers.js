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
                gameStatusResource.save({consoleId: 0, gameId: game.id, status: 'IN_PROGRESS'}, function (data) {
                    $scope.todoList.splice(index, 1);
                });
            });

        };

    })
;

