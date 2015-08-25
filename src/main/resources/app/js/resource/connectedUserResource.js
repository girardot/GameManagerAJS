'use strict';

angular.module('gameManager.connectedUserResource', []).factory('connectedUserResource', function($resource) {
    return $resource('/services/connectedUser',{});
})
