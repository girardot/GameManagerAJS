'use strict';

angular.module('gameManager.gameToDoResource', [])
    .factory('gameToDoResource', function ($resource) {
        return $resource('/services/toDoGame/');
    });
