'use strict';

//Declare app level module which depends on filters, and services
var gameManager = angular.module('gameManager', [
        'ngRoute',
        'ngResource',
        'gameManager.gameResource',
        'gameManager.gameStatusResource',
        'gameManager.gameDematerializeResource',
        'gameManager.consoleResource',
        'gameManager.filters',
        'gameManager.services',
        'gameManager.directives',
        'gameManager.controllers'
    ])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/games/:consoleId', {templateUrl: 'partials/games.html', controller: 'GameController'});
        $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
        $routeProvider.otherwise({redirectTo: '/view1'});
    }]);
