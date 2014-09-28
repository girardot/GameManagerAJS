import jgt.model.GameProgression;
import jgt.service.ConsoleGameService;
import jgt.service.JsonConverter;
import jgt.service.GameToBuyService;
import jgt.service.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Long.parseLong;
import static spark.Spark.*;

public class ServerGameManager {


    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ServerGameManager.class);


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        final JsonTransformer jsonTransformer = applicationContext.getBean(JsonTransformer.class);
        final JsonConverter jsonConverter = applicationContext.getBean(JsonConverter.class);
        final ConsoleGameService consoleGameService = applicationContext.getBean(ConsoleGameService.class);
        final GameToBuyService toBuyGameService = applicationContext.getBean(GameToBuyService.class);

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        // CONSOLE
        get("/services/console", (request, response) -> consoleGameService.findAll(), jsonTransformer);
        post("/services/console", (request, response) -> consoleGameService.saveConsole(request.body()), jsonTransformer);
        delete("/services/console/:consoleId", (request, response) -> consoleGameService.deleteConsole(parseLong(request.params("consoleId"))));

        // GAME
        get("/services/console/:consoleId/game", (request, response) -> consoleGameService.findGameByConsoleId(parseLong(request.params("consoleId"))), jsonTransformer);
        post("/services/console/:consoleId/game", (request, response) -> consoleGameService.saveGame(request.body()), jsonTransformer);
        post("/services/console/:consoleId/game/:gameId/status", (request, response) -> {
            long gameId = parseLong(request.params("gameId"));
            GameProgression gameProgression = jsonConverter.convertJsonToGameProgression(request.body());
            return consoleGameService.changeGameStatus(gameId, gameProgression);
        }, jsonTransformer);
        post("/services/console/:consoleId/game/:gameId/toogleDematerialized", (request, response) -> consoleGameService.toogleDematerialized(parseLong(request.params("gameId"))), jsonTransformer);
        delete("/services/console/game/:gameId", (request, response) -> consoleGameService.deleteGame(parseLong(request.params("gameId"))));

        // TO_BUY_GAME
        get("/services/toBuyGame", (request, response) -> toBuyGameService.findAllByOrder(), jsonTransformer);
        post("/services/toBuyGame", (request, response) -> toBuyGameService.saveGameToBuy(request.body()), jsonTransformer);
        delete("/services/toBuyGame/:gameToBuyId", (request, response) -> toBuyGameService.deleteGame(parseLong(request.params("gameToBuyId"))));

        // OTHER
        exception(Exception.class, (e, request, response) -> {
            System.out.println(request.body());
            System.out.println(e.getMessage());
            response.status(500);
        });

        before((request, response) -> logger.info("request {}", request.pathInfo()));

    }

}
