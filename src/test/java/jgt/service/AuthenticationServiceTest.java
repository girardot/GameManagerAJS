package jgt.service;

import jgt.model.Credentials;
import jgt.repository.AuthenticationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;

    @Mock
    private AuthenticationRepository authenticationRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        authenticationService = new AuthenticationService(authenticationRepository);
    }

    @Test
    public void authentication_should_success_when_already_authenticated() {
        // Given
        boolean authenticatedSessionField = true;
        Credentials credentials = new Credentials("girardot.jul@gmail.com", "myPassword");

        // When
        boolean success = authenticationService.tryToAuthenticate(credentials, authenticatedSessionField);

        // Then
        assertThat(success).isTrue();
    }

    @Test
    public void authentication_should_fail_when_password_is_wrong() {
        // Given
        boolean authenticatedSessionField = false;
        Credentials credentials = new Credentials("girardot.jul@gmail.com", "myPassword");

        when(authenticationRepository.findCredentialsBy("girardot.jul@gmail.com")).thenReturn(new Credentials("girardot.jul@gmail.com", "abc"));

        // When
        boolean success = authenticationService.tryToAuthenticate(credentials, authenticatedSessionField);

        // Then
        assertThat(success).isFalse();
    }

    @Test
    public void authentication_should_fail_when_user_does_not_exist() {
        // Given
        boolean authenticatedSessionField = false;
        Credentials credentials = new Credentials("girardot.jul@gmail.com", "myPassword");

        when(authenticationRepository.findCredentialsBy("girardot.jul@gmail.com")).thenReturn(null);

        // When
        boolean success = authenticationService.tryToAuthenticate(credentials, authenticatedSessionField);

        // Then
        assertThat(success).isFalse();
    }


    @Test
    public void authentication_should_success() {
        // Given
        boolean authenticatedSessionField = false;

        Credentials credentials = new Credentials("girardot.jul@gmail.com", "myPassword");

        when(authenticationRepository.findCredentialsBy("girardot.jul@gmail.com")).thenReturn(new Credentials("girardot.jul@gmail.com", "myPassword"));

        // When
        boolean success = authenticationService.tryToAuthenticate(credentials, authenticatedSessionField);

        // Then
        assertThat(success).isTrue();
    }

}
