package service;

import model.Console;
import model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.ConsoleRepository;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class JsonConverterTest {

    @Mock
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_convert_json_to_game() {
        // Given
        JsonConverter jsonConverter = new JsonConverter(consoleRepository);

        Console console = new Console();
        console.setId(1L);
        when(consoleRepository.findById(1L)).thenReturn(console);

        // When
        Game game = jsonConverter.convertJsonToGame("{\"console_id\": \"1\", \"title\": \"newGame\"}");

        // Then
        assertThat(game.getTitle()).isEqualTo("newGame");
    }

}
