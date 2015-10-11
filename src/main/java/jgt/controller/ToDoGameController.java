package jgt.controller;

import jgt.service.GameToDoService;
import spark.ResponseTransformer;

import static java.lang.Long.parseLong;
import static jgt.session.SessionUtils.getConnectedUserEmail;
import static spark.Spark.*;

public class ToDoGameController {

    public ToDoGameController(GameToDoService gameToDoService, ResponseTransformer jsonTransformer) {
        get("/services/toDoGame", (request, response) -> gameToDoService.findAll(getConnectedUserEmail(request.session())), jsonTransformer);

        //post("/services/toDoGameOrder", (request, response) -> toBuyGameService.changeOrders(request.body(), getConnectedUserEmail(request.session())));

    }

}
