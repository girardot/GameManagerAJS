'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function () {

    beforeEach(function () {
        this.addMatchers({
            toEqualData: function (expected) {
                return angular.equals(this.actual, expected);
            }
        });
    });

    beforeEach(module('gameManager'));
    beforeEach(module('gameManager.controllers'));
    beforeEach(module('gameManager.consoleResource'));

    describe('ConsoleController', function () {

        var scope, consoleController, $httpBackend;

        beforeEach(inject(function (_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;

            $httpBackend.expectGET('/services/console').respond([
                {id: "1", name: 'ps1'}
            ]);


            scope = $rootScope.$new();
            consoleController = $controller("ConsoleController", {$scope: scope});
        }));

        it('should add a new console', inject(function () {
            // Given
            var existingConsole = {id: "1", name: 'ps1'};
            var newConsole = {id: "2", name: "ps2"};

            expect(scope.consoles).toEqualData([]);
            expect(scope.consoles.length).toEqual(0);

            // load
            $httpBackend.flush();

            expect(scope.consoles.length).toEqual(1);
            expect(scope.consoles).toEqualData([
                existingConsole
            ]);

            // When
            scope.newConsole = newConsole;
            scope.addConsole();

            $httpBackend.expectPOST('/services/console', newConsole).respond(newConsole, '');
            $httpBackend.flush();

            // Then
            console.log(scope.consoles);
            expect(scope.consoles.length).toEqual(2);

//            expect(scope.consoles).toEqualData([
//                [
//                    existingConsole,
//                    newConsole
//                ]
//            ]);
        }));

    });


    it('should ....', inject(function () {
        //spec body
    }));

    it('should ....', inject(function () {
        //spec body
    }));
});
