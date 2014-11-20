package jgt.service;

import jgt.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    @Inject
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    private boolean authenticate(String email, String password) {
        return authenticationRepository.authenticate(email, password);
    }

    public boolean tryToAuthenticate(String login, String password, boolean isAuthenticatedSessionField) {
        if (isAuthenticatedSessionField) {
            return true;
        } else {
            boolean authenticationSuccess = authenticate(login, password);
            if (authenticationSuccess) {
                return true;
            } else {
                return false;
            }
        }
    }

}
