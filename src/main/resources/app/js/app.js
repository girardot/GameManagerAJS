'use strict';

//Declare app level module which depends on filters, and services
var gameManager = angular.module('gameManager', [
        'ngRoute',
        'ngResource',
        'gameManager.gameResource',
        'gameManager.gameToBuyResource',
        'gameManager.gameToDoResource',
        'gameManager.changeGameToBuyOrderResource',
        'gameManager.gameStatusResource',
        'gameManager.gameDematerializeResource',
        'gameManager.consoleResource',
        'gameManager.connectedUserResource',
        'gameManager.filters',
        'gameManager.services',
        'gameManager.directives',
        'gameManager.biblioControllers',
        'gameManager.gameToBuyControllers',
        'gameManager.todoListControllers',
        'gameManager.authenticationControllers'
    ])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/biblio', {templateUrl: 'partials/biblio.html', controller: 'BiblioController'});
        $routeProvider.when('/todoList', {templateUrl: 'partials/todoList.html', controller: 'TodoListController'});
        $routeProvider.when('/tobuyList', {templateUrl: 'partials/tobuyList.html', controller: 'GameToBuyListController'});
        $routeProvider.when('/signIn', {templateUrl: 'partials/authentication.html', controller: 'AuthenticationController'});
        $routeProvider.otherwise({redirectTo: '/signIn'});
    }]);
