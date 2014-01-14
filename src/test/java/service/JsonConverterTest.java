package service;

import model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class JsonConverterTest {

    @Test
    public void should_convert_json_to_game() {
        // Given
        JsonConverter jsonConverter = new JsonConverter();

        // When
       Game game = jsonConverter.convertJsonToGame("{\"consoleId\": \"1\", \"title\": \"newGame\"}");

        // Then
        assertThat(game.getTitle()).isEqualTo("newGame");
    }

}
