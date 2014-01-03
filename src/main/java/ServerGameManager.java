import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import model.Console;
import model.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.ConsoleRepository;
import repository.GameRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerGameManager {

    public static void main(String[] args) {

        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");

        final GameRepository gameRepository = ap.getBean(GameRepository.class);
        final ConsoleRepository consoleRepository = ap.getBean(ConsoleRepository.class);

        final ObjectMapper objectMapper = new ObjectMapper();

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/services/console") {
            @Override
            public Object handle(Request request, Response response) {

                List<Console> consoles = consoleRepository.findAll();

                StringWriter stringWriter = new StringWriter();

                try {
                    objectMapper.writeValue(stringWriter, consoles);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                return stringWriter.toString();
            }
        });

        get(new Route("/services/console/:consoleId/game") {
            @Override
            public Object handle(Request request, Response response) {

                long consoleId = Long.parseLong(request.params("consoleId"));
                List<Game> games = gameRepository.findByConsoleId(consoleId);
                StringWriter stringWriter = new StringWriter();

                try {
                    objectMapper.writeValue(stringWriter, games);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                return stringWriter.toString();
            }
        });

    }
}
