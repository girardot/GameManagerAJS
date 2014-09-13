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
        $routeProvider.when('/biblio', {templateUrl: 'partials/biblio.html', controller: 'BiblioController'});
        $routeProvider.when('/todo', {templateUrl: 'partials/todo.html', controller: 'BiblioController'});
        $routeProvider.when('/tobuy', {templateUrl: 'partials/tobuy.html', controller: 'BiblioController'});
        $routeProvider.otherwise({redirectTo: '/biblio'});
    }]);
