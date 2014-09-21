'use strict';

angular.module('gameManager.gameToBuyControllers', [])
    .controller('GameToBuyListController', function ($scope, gameToBuyResource) {
        $scope.gameToBuyList = gameToBuyResource.query();

        $scope.addGameToBuy = function () {

            gameToBuyResource.save($scope.newGameToBuy, function (data) {
                $scope.gameToBuyList.push(data);
                $scope.newGameToBuy = "";
            });
        };

    })
;