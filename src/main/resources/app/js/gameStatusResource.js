'use strict';

angular.module('gameManager.gameStatusResource', []).factory('gameStatusResource', function($resource) {
    return $resource('/services/console/:consoleId/game/:gameId/status', {consoleId:'@consoleId', gameId:'@gameId'} );
})
