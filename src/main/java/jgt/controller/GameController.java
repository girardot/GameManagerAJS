package jgt.controller;

import jgt.model.GameProgression;
import jgt.service.ConsoleGameService;
import jgt.service.JsonConverter;
import jgt.service.JsonTransformer;

import static java.lang.Long.parseLong;
import static spark.Spark.*;

public class GameController {

    public GameController(ConsoleGameService consoleGameService, JsonConverter jsonConverter, JsonTransformer jsonTransformer) {

        get("/services/console/:consoleId/game", (request, response) -> consoleGameService.findGameByConsoleId(parseLong(request.params("consoleId"))), jsonTransformer);

        post("/services/console/:consoleId/game", (request, response) -> consoleGameService.saveGame(request.body()), jsonTransformer);

        post("/services/console/:consoleId/game/:gameId/status", (request, response) -> {
            long gameId = parseLong(request.params("gameId"));
            GameProgression gameProgression = jsonConverter.convertJsonToGameProgression(request.body());
            return consoleGameService.changeGameStatus(gameId, gameProgression);
        }, jsonTransformer);

        post("/services/console/:consoleId/game/:gameId/toogleDematerialized", (request, response) -> consoleGameService.toogleDematerialized(parseLong(request.params("gameId"))), jsonTransformer);

        delete("/services/console/game/:gameId", (request, response) -> consoleGameService.deleteGame(parseLong(request.params("gameId"))));
    }

}
