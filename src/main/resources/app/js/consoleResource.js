'use strict';

angular.module('gameManager.consoleResource', []).factory('consoleResource', function($resource) {
      return $resource('/services/console/:consoleId', {consoleId:'@consoleId'} );
})
