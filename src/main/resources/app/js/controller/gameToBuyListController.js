'use strict';

angular.module('gameManager.gameToBuyControllers', [])
    .controller('GameToBuyListController', function ($scope, gameToBuyResource) {
        function refeshGameToBuyList() {
            $scope.gameToBuyList = gameToBuyResource.query();
        }

        refeshGameToBuyList();

        $scope.addGameToBuy = function () {

            gameToBuyResource.save($scope.newGameToBuy, function (data) {
                refeshGameToBuyList();
                $scope.newGameToBuy = "";
            });
        };

        $scope.displayRemoveGameToBuyModal = function (index) {
            var gameToBuy = $scope.gameToBuyList[index];

            openModalDeletion('Game To Buy', gameToBuy.title);

            $('#modalDeletionButtonYes').unbind("click").on('click', function () {
                closeModalDeletion();
                gameToBuyResource.remove({gameToBuyId: gameToBuy.id}, function () {
                    refeshGameToBuyList();
                });
            });
        };

    })
;