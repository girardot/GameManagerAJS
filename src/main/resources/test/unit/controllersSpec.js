'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function () {
    beforeEach(module('gameManager.controllers'));

    beforeEach(module('gameManager'));

    describe('ConsoleController', function () {

        var scope, consoleController, $httpBackend;


        beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;

            $httpBackend.expectGET('/services/console/').
                respond([{name: 'ps2'}, {name: 'ps3'}]);

            scope = $rootScope.$new();

            consoleController = $controller("ConsoleController", {$scope: scope});
        }));

        it('should add a new console', inject(function () {

            console.log(scope.consoles);
            expect(scope.consoles).toEqual([]);
            // when

            // then
//            expect(scope.consoles).toEqual([]);
        }));

    });


    it('should ....', inject(function () {
        //spec body
    }));

    it('should ....', inject(function () {
        //spec body
    }));
});
