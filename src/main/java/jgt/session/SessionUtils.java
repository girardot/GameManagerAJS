package jgt.session;

import spark.Request;
import spark.Session;

import java.util.Objects;

public class SessionUtils {

    public final static String SESSION_AUTHENTICATION_FIELD = "authenticated";
    public final static String SESSION_EMAIL_FIELD = "email";

    public static boolean isUserAuthenticated(Session session) {
        return session.attribute(SESSION_AUTHENTICATION_FIELD) == null ? false : session.attribute(SESSION_AUTHENTICATION_FIELD);
    }

    public static void createNewSession(Request request, String login) {
        if (!Objects.equals(getConnectedUserEmail(request.session()), login)) {
            request.session(true);
            request.session().attribute(SESSION_EMAIL_FIELD, login);
        }
    }

    public static String getConnectedUserEmail(Session session) {
        return session.attribute(SESSION_EMAIL_FIELD);
    }

}
