package jgt.service;

import jgt.model.*;
import jgt.repository.ConsoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class JsonConverterTest {

    @Mock
    private ConsoleRepository consoleRepository;

    private JsonConverter jsonConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        jsonConverter = new JsonConverter(consoleRepository);
    }

    @Test
    public void should_convert_json_to_game() {
        // Given
        Console console = new Console();
        console.setId(1L);
        when(consoleRepository.findById(1L)).thenReturn(console);

        // When
        Game game = jsonConverter.convertJsonToGame("{\"consoleId\": \"1\", \"title\": \"newGame\"}");

        // Then
        assertThat(game.getConsole()).isEqualTo(console);
        assertThat(game.getTitle()).isEqualTo("newGame");
    }

    @Test
    public void should_convert_json_to_credentials() {
        // Given

        // When
        Credentials credentials = jsonConverter.convertJsonToCredential("{\"email\": \"girardot.jul@gmail.com\", \"password\": \"1234\"}");

        // Then
        assertThat(credentials.getEmail()).isEqualTo("girardot.jul@gmail.com");
        assertThat(credentials.getPassword()).isEqualTo("1234");
    }

    @Test
    public void should_convert_game_to_json() {
        // Given
        Game gameToConvert = new Game();
        gameToConvert.setId(1L);
        gameToConvert.setTitle("gameTitle");
        gameToConvert.setProgression(GameProgression.DONE);
        gameToConvert.setConsole(new Console());

        // When
        String jsonGame = jsonConverter.convertToJson(gameToConvert);

        // Then
        assertThat(jsonGame).isEqualTo("{\"id\":1,\"title\":\"gameTitle\",\"console_id\":0,\"progression\":\"DONE\",\"isDematerialized\":\"false\"}");
    }

    @Test
    public void should_convert_user_to_json() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setFirstname("julien");
        user.setLastname("girardot");
        user.setEmail("girardot.jul@gmail.com");

        // When
        String jsonUser = jsonConverter.convertToJson(user);

        // Then
        assertThat(jsonUser).isEqualTo("{\"id\":1,\"firstname\":\"julien\",\"lastname\":\"girardot\",\"email\":\"girardot.jul@gmail.com\"}");
    }

    @Test
    public void should_convert_json_to_game_progression() {
        // Given
        String json = "{\"consoleId\":\"1\", \"gameId\":\"1\", \"status\":\"DONE\"}";

        // When
        GameProgression gameProgression = jsonConverter.convertJsonToGameProgression(json);

        // Then
        assertThat(gameProgression).isEqualTo(GameProgression.DONE);
    }

}
