import jgt.model.Credentials;
import jgt.model.GameProgression;
import jgt.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spark.Request;

import static java.lang.Long.parseLong;
import static org.eclipse.jetty.http.HttpStatus.ACCEPTED_202;
import static org.eclipse.jetty.http.HttpStatus.UNAUTHORIZED_401;
import static spark.Spark.*;

public class ServerGameManager {


    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ServerGameManager.class);


        final String SESSION_AUTHENTICATION_FIELD = "authenticated";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        final JsonTransformer jsonTransformer = applicationContext.getBean(JsonTransformer.class);
        final JsonConverter jsonConverter = applicationContext.getBean(JsonConverter.class);
        final ConsoleGameService consoleGameService = applicationContext.getBean(ConsoleGameService.class);
        final GameToBuyService toBuyGameService = applicationContext.getBean(GameToBuyService.class);
        final AuthenticationService authenticationService = applicationContext.getBean(AuthenticationService.class);

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
        post("/services/toBuyGameOrder", (request, response) -> toBuyGameService.changerOrders(request.body()));

        // AUTHENTICATION
        post("/services/authentication", (request, response) -> {

            Credentials credentials = jsonConverter.convertJsonToCredential(request.body());

            Boolean isAuthenticatedSessionField = request.session().attribute(SESSION_AUTHENTICATION_FIELD) == null ? false : request.session().attribute(SESSION_AUTHENTICATION_FIELD);
            if (!authenticationService.tryToAuthenticate(credentials, isAuthenticatedSessionField)) {
                halt(UNAUTHORIZED_401, "Authentication Failed");
            }


            createSessionIfDoesNotExist(request, credentials.getEmail());
            request.session().attribute(SESSION_AUTHENTICATION_FIELD, true);

            response.status(ACCEPTED_202);

            return true;
        }, jsonTransformer);

        // OTHER
        exception(Exception.class, (e, request, response) -> {
            System.out.println(request.body());
            System.out.println(e.getMessage());
            System.out.println(e);
            response.status(500);
        });

        before((request, response) -> {
            logger.info("request {}", request.pathInfo());
            if(request.pathInfo().contains("/services/") && !request.pathInfo().contains("/services/authentication")&& request.session().attribute(SESSION_AUTHENTICATION_FIELD) != Boolean.TRUE) {
                response.redirect("/#/signIn", 401);
                halt(401, "You are not welcome here");
            }
        });

    }

    private static void createSessionIfDoesNotExist(Request request, String login) {
        if (request.session().id() == null) {
            request.session(true);
            request.session().attribute("email", login);
        }
    }

}
