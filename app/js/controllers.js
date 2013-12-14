//'use strict';

/* Controllers */

//angular.module('gameManager.controllers', []).
    gameManager.controller('ConsoleController', function($scope, $http) {
        $scope.consoles = [
            {'name': 'ps1',
                'games': [{'title':'game1'}, {'title':'game2'}]
            },
            {'name': 'ps2',
                'games': [{'title':'game3'}, {'title':'game4'}]
            },
            {'name': 'ps3',
                'games': [{'title':'game5'}, {'title':'game6'}]
            }
        ];
        /* $http.get('consoles/consoles.json').success(function(data) {
         $scope.consoles = data;
         });*/
  }).
    controller('ConsoleController2', function($scope) {
    $scope.consoles = [
        {'name': 'ps1',
            'games': [{'title':'game1'}, {'title':'game2'}]
        },
        {'name': 'ps2',
            'games': [{'title':'game3'}, {'title':'game4'}]
        },
        {'name': 'ps3',
            'games': [{'title':'game5'}, {'title':'game6'}]
        }
    ];
})
;