'use strict';

angular.module('gameManager.directives', [])
    .directive('deleteModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/delete-modal.html'
        };
    })
    .directive('consoles', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/consoles.html'
        };
    })
    .directive('games', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/games.html'
        };
    })
    .directive('toBuyGames', function () {

        return {
            restrict: 'E',
            templateUrl: 'partials/tobuyGames.html'
        };
    })
    ;