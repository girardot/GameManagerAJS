'use strict';

angular.module('gameManager.todoListControllers', [])
    .controller('TodoListController', function ($scope) {
        $scope.todoList = [
            {"title": "aaa"},
            {"title": "bbb"}
        ];
    })
;

