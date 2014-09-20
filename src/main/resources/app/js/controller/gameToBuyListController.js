'use strict';

angular.module('gameManager.gameToBuyControllers', [])
    .controller('GameToBuyListController', function ($scope, gameToBuyResource) {
        $scope.gameToBuyList = gameToBuyResource.query();
    })
;