package jgt.controller;

import jgt.service.GameToBuyService;
import spark.ResponseTransformer;

import static java.lang.Long.parseLong;
import static jgt.session.SessionUtils.getConnectedUserEmail;
import static spark.Spark.*;

public class ToBuyGameController {

    public ToBuyGameController(GameToBuyService toBuyGameService, ResponseTransformer jsonTransformer) {
        get("/services/toBuyGame", (request, response) -> toBuyGameService.findAllByOrder(getConnectedUserEmail(request.session())), jsonTransformer);

        post("/services/toBuyGame", (request, response) -> toBuyGameService.saveGameToBuy(request.body(), getConnectedUserEmail(request.session())), jsonTransformer);

        delete("/services/toBuyGame/:gameToBuyId", (request, response) -> toBuyGameService.deleteGame(parseLong(request.params("gameToBuyId"))));

        post("/services/toBuyGameOrder", (request, response) -> toBuyGameService.changeOrders(request.body(), getConnectedUserEmail(request.session())));
    }

}
