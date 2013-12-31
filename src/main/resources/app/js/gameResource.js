'use strict';

angular.module('gameManager.gameResource', []).factory('gameResource', function($resource) {
    return $resource('/services/console/:consoleId/game/:gameId', {consoleId:'@consoleId', gameId:'@gameId'} );
})
