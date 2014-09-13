'use strict';

/* Directives */


angular.module('gameManager.directives', [])
    .directive('deleteModal', function() {
        return {
            templateUrl: 'partials/delete-modal.html'
        };
    });