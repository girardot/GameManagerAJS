'use strict';

angular.module('gameManager.changeGameToBuyOrderResource', [])
    .factory('changeGameToBuyOrderResource', function ($resource) {
        return $resource('/services/toBuyGameOrder/:toBuyGameOrderIds', {toBuyGameOrderIds:'@toBuyGameOrderIds'});
    });
