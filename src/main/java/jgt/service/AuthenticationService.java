package jgt.service;

import jgt.model.Credentials;
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

    private boolean authenticate(Credentials credentials) {
        return authenticationRepository.authenticate(credentials);
    }

    public boolean tryToAuthenticate(Credentials credentials, boolean isAuthenticatedSessionField) {
        if (isAuthenticatedSessionField) {
            return true;
        } else {
            boolean authenticationSuccess = authenticate(credentials);
            if (authenticationSuccess) {
                return true;
            } else {
                return false;
            }
        }
    }

}
