import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

import spark.Request;
import spark.Response;
import spark.Route;

public class ServerGameManager {

    public static void main(String[] args) {

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/services/consoles") {
            @Override
            public Object handle(Request request, Response response) {
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

        get(new Route("/services/games/:consoleId") {
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
