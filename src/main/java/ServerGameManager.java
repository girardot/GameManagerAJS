import jgt.model.GameProgression;
import jgt.service.ConsoleGameService;
import jgt.service.JsonConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Long.parseLong;
import static spark.Spark.*;

public class ServerGameManager {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        final JsonConverter jsonConverter = applicationContext.getBean(JsonConverter.class);
        final ConsoleGameService consoleGameService = applicationContext.getBean(ConsoleGameService.class);

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        get("/services/console", (request, response) -> consoleGameService.findAll());

        post("/services/console", (request, response) -> consoleGameService.saveConsole(request.body()));

        get("/services/console/:consoleId/game", (request, response) -> consoleGameService.findGameByConsoleId(parseLong(request.params("consoleId"))));

        post("/services/console/:consoleId/game", (request, response) -> consoleGameService.saveGame(request.body()));

        post("/services/console/:consoleId/game/:gameId/status", (request, response) -> {
            long gameId = parseLong(request.params("gameId"));
            GameProgression gameProgression = jsonConverter.convertJsonToGameProgression(request.body());
            return consoleGameService.changeGameStatus(gameId, gameProgression);
        });

        post("/services/console/:consoleId/game/:gameId/toogleDematerialized", (request, response) -> consoleGameService.toogleDematerialized(parseLong(request.params("gameId"))));

        delete("/services/console/:consoleId", (request, response) -> consoleGameService.deleteConsole(parseLong(request.params("consoleId"))));

        delete("/services/console/game/:gameId", (request, response) -> consoleGameService.deleteGame(parseLong(request.params("gameId"))));

        exception(Exception.class, (e, request, response) -> {
            System.out.println(request.body());
            System.out.println(e.getMessage());
            response.status(500);
        });

    }

}
