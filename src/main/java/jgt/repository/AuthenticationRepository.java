package jgt.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepository {

    public boolean authenticate(String email, String password) {
        return true;
    }

}
