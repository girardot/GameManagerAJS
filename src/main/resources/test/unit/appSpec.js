'use strict';

describe("gameManager: Testing Modules", function() {
    describe("gameManager Module:", function() {

        var module;
        beforeEach(function() {
            module = angular.module("gameManager");
        });

        it("should be registered", function() {
            expect(module).not.toEqual(null);
        });

        describe("Dependencies:", function() {

            var deps;
            var hasModule = function(m) {
                return deps.indexOf(m) >= 0;
            };

            beforeEach(function() {
                deps = module.value('ngRoute').requires;
            });

            //you can also test the module's dependencies
            it("should have gameManager.Controllers as a dependency", function() {
                expect(hasModule('gameManager.controllers')).toEqual(true);
            });

            it("should have App.Directives as a dependency", function() {
                expect(hasModule('gameManager.directives')).toEqual(true);
            });

            it("should have gameManager.filters as a dependency", function() {
                expect(hasModule('gameManager.filters')).toEqual(true);
            });

            it("should have ngRoute as a dependency", function() {
                expect(hasModule('ngRoute')).toEqual(true);
            });

            it("should have ngResource as a dependency", function() {
                expect(hasModule('ngResource')).toEqual(true);
            });

            it("should have gameManager.services as a dependency", function() {
                expect(hasModule('gameManager.services')).toEqual(true);
            });

            it("should have gameManager.gameResource as a dependency", function() {
                expect(hasModule('gameManager.gameResource')).toEqual(true);
            });

            it("should have gameManager.consoleResource as a dependency", function() {
                expect(hasModule('gameManager.consoleResource')).toEqual(true);
            });
        });
    });
});