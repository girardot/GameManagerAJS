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

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });

    }
}
