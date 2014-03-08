package jgt.service;

import jgt.model.Console;
import jgt.model.Game;
import jgt.model.GameProgression;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import jgt.repository.ConsoleRepository;

import javax.inject.Inject;

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
    public void should_convert_game_to_json() {
        // Given
        Game gameToConvert = new Game();
        gameToConvert.setId(1L);
        gameToConvert.setTitle("gameTitle");
        gameToConvert.setProgression(GameProgression.DONE);

        // When
        String jsonGame = jsonConverter.convertToJson(gameToConvert);

        // Then
        assertThat(jsonGame).isEqualTo("{\"id\":1,\"title\":\"gameTitle\"}");
    }

}