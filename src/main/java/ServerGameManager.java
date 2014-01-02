import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.ConsoleRepository;
import repository.GameRepository;
import spark.Request;
import spark.Response;
import spark.Route;

public class ServerGameManager {

    public static void main(String[] args) {

        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");

        final GameRepository gameRepository = ap.getBean(GameRepository.class);
        final ConsoleRepository consoleRepository = ap.getBean(ConsoleRepository.class);

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/services/console") {
            @Override
            public Object handle(Request request, Response response) {

                //List<Console> consoles = consoleRepository.findAll();

                return "[\n" +
                        "    {\"id\":1, \"name\": \"ps1\",\n" +
                        "        \"games\": [{\"title\":\"game1\"}, {\"title\":\"game2\"}]\n" +
                        "    },\n" +
                        "    {\"id\":2, \"name\": \"ps2\",\n" +
                        "        \"games\": [{\"title\":\"game3\"}, {\"title\":\"game4\"}]\n" +
                        "    },\n" +
                        "    {\"id\":3, \"name\": \"ps3\",\n" +
                        "        \"games\": [{\"title\":\"game5\"}, {\"title\":\"game6\"}]\n" +
                        "    }\n" +
                        "]";
            }
        });

        get(new Route("/services/console/:consoleId/game") {
            @Override
            public Object handle(Request request, Response response) {
                return "[\n" +
                        "    {\"id\": 1, \"title\":\"ps1-game1("+request.params("consoleId")+")\", \"progression\":\"TO_DO\"},\n" +
                        "    {\"id\": 2, \"title\":\"ps1-game2\", \"progression\":\"IN_PROGRESS\"},\n" +
                        "    {\"id\": 3, \"title\":\"ps1-game3\", \"progression\":\"DONE\"},\n" +
                        "    {\"id\": 4, \"title\":\"ps1-game4\", \"progression\":\"DONE\"},\n" +
                        "    {\"id\": 5, \"title\":\"ps1-game5\", \"progression\":\"TO_DO\"},\n" +
                        "    {\"id\": 6, \"title\":\"ps1-game6\", \"progression\":\"TO_DO\"},\n" +
                        "    {\"id\": 7, \"title\":\"ps1-game7\", \"progression\":\"TO_DO\"}\n" +
                        "]";
            }
        });

    }
}
