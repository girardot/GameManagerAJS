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

//            $httpBackend.expectPOST('/services/console').respond(201, '');

            scope = $rootScope.$new();
            consoleController = $controller("ConsoleController", {$scope: scope});
        }));

        it('should add a new console', inject(function () {
            // Given
            expect(scope.consoles).toEqualData([]);
            $httpBackend.flush();
            expect(scope.consoles).toEqualData([
                {id: "1", name: 'ps1'}
            ]);

            // When
            scope.newConsole = {id: "2", name: "ps2"};
            scope.addConsole();

            // Then
            expect(scope.consoles).toEqualData([
                    [
                        {id: "1", name: 'ps1'},
                        {id: "2", name: 'ps2'}
                    ]
                ]);
        }));

    });


    it('should ....', inject(function () {
        //spec body
    }));

    it('should ....', inject(function () {
        //spec body
    }));
});
