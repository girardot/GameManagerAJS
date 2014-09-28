'use strict';

angular.module('gameManager.gameToBuyResource', [])
    .factory('gameToBuyResource', function ($resource) {
        return $resource('/services/toBuyGame/:gameToBuyId', {gameToBuyId:'@gameToBuyId'});
    });
