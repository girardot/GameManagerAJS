package jgt.controller;

import jgt.model.Credentials;
import jgt.service.AuthenticationService;
import jgt.service.JsonConverter;
import jgt.service.JsonTransformer;
import jgt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Session;

import static jgt.session.SessionUtils.*;
import static org.eclipse.jetty.http.HttpStatus.ACCEPTED_202;
import static org.eclipse.jetty.http.HttpStatus.UNAUTHORIZED_401;
import static spark.Spark.*;

public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(AuthenticationService authenticationService, UserService userService, JsonConverter jsonConverter, JsonTransformer jsonTransformer) {
        post("/services/authentication", (request, response) -> {

            Session session = request.session();
            Credentials credentials = jsonConverter.convertJsonToCredential(request.body());

            if (!authenticationService.tryToAuthenticate(credentials, isUserAuthenticated(session))) {
                logger.info("Authentication Failed for {}", credentials.getEmail());
                halt(UNAUTHORIZED_401, "Authentication Failed");
            }

            createNewSession(request, credentials.getEmail());
            session.attribute(SESSION_AUTHENTICATION_FIELD, true);

            logger.info("authentication success for {}", getConnectedUserEmail(session));
            response.status(ACCEPTED_202);

            return userService.findByEmail(getConnectedUserEmail(request.session()));
        }, jsonTransformer);

        post("/services/signOut", (request, response) -> {
            Session session = request.session();
            logger.info("start sign out for {}", getConnectedUserEmail(session));
            session.attribute(SESSION_AUTHENTICATION_FIELD, false);
            session.attribute(SESSION_EMAIL_FIELD, "");
            logger.info("end sign out for {}", getConnectedUserEmail(session));
            response.status(ACCEPTED_202);
            return true;
        }, jsonTransformer);

        get("/services/connectedUser", (request, response) -> userService.findByEmail(getConnectedUserEmail(request.session())), jsonTransformer);

    }

}
