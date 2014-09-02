import jgt.model.Console;
import jgt.model.Game;
import jgt.model.GameProgression;
import jgt.repository.ConsoleRepository;
import jgt.repository.GameRepository;
import jgt.service.JsonConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

import static spark.Spark.*;

public class ServerGameManager {

    public static void main(String[] args) {

        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");

        final GameRepository gameRepository = ap.getBean(GameRepository.class);
        final ConsoleRepository consoleRepository = ap.getBean(ConsoleRepository.class);
        final JsonConverter jsonConverter = ap.getBean(JsonConverter.class);

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/services/console") {
            @Override
            public Object handle(Request request, Response response) {
                return jsonConverter.convertToJson(consoleRepository.findAll());
            }
        });

        post(new Route("/services/console") {
            @Override
            public Object handle(Request request, Response response) {
                Console console = new Console(request.body());
                consoleRepository.saveOrUpdate(console);
                return jsonConverter.convertToJson(console);
            }
        });

        get(new Route("/services/console/:consoleId/game") {
            @Override
            public Object handle(Request request, Response response) {
                long consoleId = Long.parseLong(request.params("consoleId"));
                List<Game> games = gameRepository.findByConsoleId(consoleId);
                return jsonConverter.convertToJson(games);
            }
        });

        post(new Route("/services/console/:consoleId/game") {
            @Override
            public Object handle(Request request, Response response) {
                Game game = jsonConverter.convertJsonToGame(request.body());
                gameRepository.saveOrUpdate(game);
                return jsonConverter.convertToJson(game);
            }
        });

        post(new Route("/services/console/:consoleId/game/:gameId/status") {
            @Override
            public Object handle(Request request, Response response) {
                long gameId = Long.parseLong(request.params("gameId"));
                Game game = gameRepository.findById(gameId);

                GameProgression gameProgression = jsonConverter.convertJsonToGameProgression(request.body());
                game.setProgression(gameProgression);
                gameRepository.saveOrUpdate(game);

                return jsonConverter.convertToJson(gameProgression);
            }
        });

        delete(new Route("/services/console/:consoleId") {
            @Override
            public Object handle(Request request, Response response) {
                long consoleId = Long.parseLong(request.params("consoleId"));
                return consoleRepository.delete(consoleId);
            }
        });

        delete(new Route("/services/console/game/:gameId") {
            @Override
            public Object handle(Request request, Response response) {
                long gameId = Long.parseLong(request.params("gameId"));
                return gameRepository.delete(gameId);
            }
        });

    }
}
