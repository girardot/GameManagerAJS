package jgt.controller;

import jgt.service.ConsoleGameService;
import jgt.service.JsonTransformer;

import static java.lang.Long.parseLong;
import static jgt.session.SessionUtils.getConnectedUserEmail;
import static spark.Spark.*;

public class ConsoleController {

    public ConsoleController(ConsoleGameService consoleGameService, JsonTransformer jsonTransformer) {
        get("/services/console", (request, response) -> consoleGameService.findAll(getConnectedUserEmail(request.session())), jsonTransformer);

        post("/services/console", (request, response) -> consoleGameService.saveConsole(request.body()), jsonTransformer);

        delete("/services/console/:consoleId", (request, response) -> consoleGameService.deleteConsole(parseLong(request.params("consoleId"))));
    }

}
