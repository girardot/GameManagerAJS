'use strict';

angular.module('gameManager.gameDematerializeResource', []).factory('gameDematerializeResource', function($resource) {
    return $resource('/services/console/:consoleId/game/:gameId/toogleDematerialized', {consoleId:'@consoleId', gameId:'@gameId'} );
})
