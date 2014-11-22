package jgt.repository;

import jgt.model.Credentials;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepository {

    public boolean authenticate(Credentials credentials) {
        return true;
    }

}
