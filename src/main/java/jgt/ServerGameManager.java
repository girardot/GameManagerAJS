package jgt;

import jgt.controller.ConsoleController;
import jgt.controller.GameController;
import jgt.controller.ToBuyGameController;
import jgt.controller.UserController;
import jgt.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static jgt.session.SessionUtils.SESSION_AUTHENTICATION_FIELD;
import static spark.Spark.*;

public class ServerGameManager {

    private static Logger logger = LoggerFactory.getLogger(ServerGameManager.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        final JsonTransformer jsonTransformer = applicationContext.getBean(JsonTransformer.class);
        final JsonConverter jsonConverter = applicationContext.getBean(JsonConverter.class);
        final ConsoleGameService consoleGameService = applicationContext.getBean(ConsoleGameService.class);
        final GameToBuyService toBuyGameService = applicationContext.getBean(GameToBuyService.class);
        final AuthenticationService authenticationService = applicationContext.getBean(AuthenticationService.class);
        final UserService userService = applicationContext.getBean(UserService.class);

        staticFileLocation("/app"); // Static files
        setPort(Integer.valueOf(System.getenv("PORT")));

        // CONSOLE
        new ConsoleController(consoleGameService, jsonTransformer);

        // GAME
        new GameController(consoleGameService, jsonConverter, jsonTransformer);

        // TO_BUY_GAME
        new ToBuyGameController(toBuyGameService, jsonTransformer);

        // AUTHENTICATION
        new UserController(authenticationService, userService, jsonConverter, jsonTransformer);

        // OTHER
        exception(Exception.class, (e, request, response) -> {
            System.out.println(request.body());
            System.out.println(e.getMessage());
            System.out.println(e);
            response.status(500);
        });

        before((request, response) -> {
            logger.info("request {}", request.pathInfo());
            if (request.pathInfo().contains("/services/") && !request.pathInfo().contains("/services/authentication") && request.session().attribute(SESSION_AUTHENTICATION_FIELD) != Boolean.TRUE) {
                logger.info("You are not welcome here");
                response.redirect("/#/signIn", 401);
                halt(401, "You are not welcome here");
            }
        });

    }

}
