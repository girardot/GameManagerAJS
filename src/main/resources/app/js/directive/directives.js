'use strict';

angular.module('gameManager.directives', [])
    .directive('deleteModal', function() {
        return {
            templateUrl: 'partials/delete-modal.html'
        };
    })
    .directive('consoles', function() {
        return {
            templateUrl: 'partials/consoles.html'
        };
    });