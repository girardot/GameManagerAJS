//'use strict';

/* Controllers */

angular.module('gameManager.controllers', []).
controller('ConsoleController', function ($scope, $http) {
    $scope.consoles = [
        {'name': 'ps1',
            'games': [
                {'title': 'game1'},
                {'title': 'game2'}
            ]
        },
        {'name': 'ps2',
            'games': [
                {'title': 'game3'},
                {'title': 'game4'}
            ]
        },
        {'name': 'ps3',
            'games': [
                {'title': 'game5'},
                {'title': 'game6'}
            ]
        }
    ];
    /* $http.get('consoles/consoles.json').success(function(data) {
     $scope.consoles = data;
     });*/
}).
    controller('GameController', function ($scope, $http, $routeParams) {

        $scope.games = [
            {'title': 'game1'},
            {'title': 'game2'}
        ];

        alert($routeParams.consoleName);
    })
;
