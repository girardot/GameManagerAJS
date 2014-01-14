import java.util.List;

import model.Console;
import model.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.ConsoleRepository;
import repository.GameRepository;
import service.JsonConverter;
import spark.Request;
import spark.Response;
import spark.Route;

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
                long consoleId = Long.parseLong(request.params("consoleId"));
                Console console = consoleRepository.findById(consoleId);
                Game game = jsonConverter.convertJsonToGame(request.body());
                game.setConsole(console);
                gameRepository.saveOrUpdate(game);
                return jsonConverter.convertToJson(game);
            }
        });

        delete(new Route("/services/console/:consoleId") {
            @Override
            public Object handle(Request request, Response response) {
                long consoleId = Long.parseLong(request.params("consoleId"));
                return consoleRepository.delete(consoleId);
            }
        });
    }
}
