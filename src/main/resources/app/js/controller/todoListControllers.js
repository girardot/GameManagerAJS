'use strict';

angular.module('gameManager.controllers', [])
    .controller('TodoListController', function ($scope) {
        $scope.todoList = [
            {"title": "aaa"},
            {"title": "bbb"}
        ];
    })
;

