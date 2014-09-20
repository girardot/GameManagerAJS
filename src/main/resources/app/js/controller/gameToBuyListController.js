'use strict';

angular.module('gameManager.controllers', [])
    .controller('GameToBuyListController', function ($scope, gameToBuyResource) {
        $scope.gameToBuyList = gameToBuyResource.query();
    })
;