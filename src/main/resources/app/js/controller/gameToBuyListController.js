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

        $scope.displayRemoveGameToBuyModal = function (index) {
            var gameToBuy = $scope.gameToBuyList[index];

            openModalDeletion('Game To Buy', gameToBuy.title);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                gameToBuyResource.remove({gameToBuyId: gameToBuy.id}, function () {
                    $scope.gameToBuyList.splice(index, 1);
                });
            });
        };

    })
;