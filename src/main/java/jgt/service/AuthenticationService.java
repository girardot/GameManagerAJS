package jgt.service;

import jgt.model.Credentials;
import jgt.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    @Inject
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    private boolean authenticate(Credentials credentials) {
        if(credentials == null) {
            return false;
        }

        Credentials storedCredentials = authenticationRepository.findCredentialsBy(credentials.getEmail());
        if(storedCredentials == null) {
            return false;
        }

        return Objects.equals(storedCredentials.getPassword(), credentials.getPassword());
    }

    public boolean tryToAuthenticate(Credentials credentials, boolean isAuthenticatedSessionField) {
        return isAuthenticatedSessionField || authenticate(credentials);
    }
}

