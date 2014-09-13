'use strict';

angular.module('gameManager.directives', [])
    .directive('deleteModal', function () {
        return {
            templateUrl: 'partials/delete-modal.html'
        };
    })
    .directive('consoles', function () {
        return {
            templateUrl: 'partials/consoles.html'
        };
    })
    .directive('games', function () {
        return {
            templateUrl: 'partials/games.html'
        };
    });