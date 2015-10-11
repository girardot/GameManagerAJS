'use strict';

angular.module('gameManager.directives', [])
    .directive('deleteModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/delete-modal.html'
        };
    })
    .directive('startToPlayModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/start-to-play-modal.html'
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
    .directive('authenticatedUser', function (connectedUserResource) {
        function initConnectedUser($scope, connectedUserResource) {
            connectedUserResource.get(function (connectedUser) {
                    $scope.connectedUser = connectedUser;
                }
            );
        }

        return {
            restrict: 'E',
            templateUrl: 'partials/connectedUser.html',
            controller: initConnectedUser
        };
    })
    .directive('toBuyGames', function () {

        function init($scope) {
            var group = $(".to-buy-list").sortable({
                group: 'to-buy-list',
                onDrop: function (item, container, _super) {
                    $scope.changeOrder(group.sortable("serialize").get().join(";"));
                    _super(item, container);
                },
                serialize: function (parent, children, isContainer) {
                    if (isContainer) {
                        return children.join()
                    }
                    return $(parent).children(".gameToBuyId").text();
                }
            });
        }

        return {
            restrict: 'E',
            templateUrl: 'partials/tobuyGames.html',
            controller: init
        };
    })
;