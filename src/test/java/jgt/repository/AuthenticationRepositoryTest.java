package jgt.repository;

import jgt.model.Credentials;
import org.junit.Test;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.assertThat;

public class AuthenticationRepositoryTest extends AbstractIntegrationTest {

    @Inject
    private AuthenticationRepository authenticationRepository;

    @Test
    public void should_find_a_credentials() {
        // Given
        String email = "girardot.jul@gmail.com";

        // When
        Credentials credentials = authenticationRepository.findCredentialsBy(email);

        // Then
        assertThat(credentials.getEmail()).isEqualTo(email);
        assertThat(credentials.getPassword()).isNotNull();
    }

}