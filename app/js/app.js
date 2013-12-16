//'use strict';
//var gameManager = angular.module('gameManager', []);

//Declare app level module which depends on filters, and services
var gameManager = angular.module('gameManager', [
  'ngRoute',
  'gameManager.filters',
  'gameManager.services',
  'gameManager.directives',
  'gameManager.controllers'
])
    .
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/games/:consoleName', {templateUrl: 'partials/games.html', controller: 'GameController'});
  $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
