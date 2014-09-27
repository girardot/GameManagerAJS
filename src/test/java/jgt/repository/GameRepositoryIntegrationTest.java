package jgt.repository;

import jgt.model.Console;
import jgt.model.Game;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class GameRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameRepository gameRepository;

    @Inject
    private ConsoleRepository consoleRepository;

    @Test
    public void should_find_game_by_title() {
        // Given
        String gameTitle = "call of duty";

        // When
        Game resultGame = gameRepository.findByTitle(gameTitle);

        // Then
        assertThat(resultGame).isNotNull();
        assertThat(resultGame.getTitle()).isEqualTo(gameTitle);
    }

    @Test
    public void should_find_game_by_id() {
        // Given
        Game existingGame = gameRepository.findByTitle("call of duty");

        // When
        Game resultGame = gameRepository.findById(existingGame.getId());

        // Then
        assertThat(resultGame.getId()).isNotNull().isEqualTo(existingGame.getId());
    }

    @Test
    public void should_find_game_by_console_id() {
        // Given
        String consoleName = "ps2";
        Console ps2 = consoleRepository.findByName(consoleName);

        // When
        List<Game> ps3Games = gameRepository.findByConsoleId(ps2.getId());

        // Then
        assertThat(ps3Games).hasSize(2);
        assertThat(extractProperty("console.name").from(ps3Games)).containsOnly(consoleName);
    }

    @Test
    public void should_delete_one_game() {
        // Given
        String gameToBeDeleted = "call of duty";
        Game existingGame = gameRepository.findByTitle(gameToBeDeleted);
        assertThatGameExistInDatabase(gameToBeDeleted);

        // When
        gameRepository.delete(existingGame.getId());

        // Then
        assertThatGameDoesNotExistInDatabase(gameToBeDeleted);
    }

    @Test
    public void should_save_game() {
        // Given
        String newGameTitle = "my game";
        Game game = new Game(newGameTitle);
        assertThatGameDoesNotExistInDatabase(newGameTitle);

        // When
        gameRepository.saveOrUpdate(game);

        // Then
        assertThatGameExistInDatabase(newGameTitle);
    }

    @Test
    public void should_update_game() {
        // Given
        String existingGameTitle = "call of duty";
        Game game = gameRepository.findByTitle(existingGameTitle);
        assertThatGameExistInDatabase(existingGameTitle);

        // When
        gameRepository.saveOrUpdate(game);

        // Then
        assertThatGameExistInDatabase(existingGameTitle);
    }

    private void assertThatGameExistInDatabase(String gameTitle) {
        assertThat(gameRepository.findByTitle(gameTitle)).isNotNull();
    }

    private void assertThatGameDoesNotExistInDatabase(String gameTitle) {
        assertThat(gameRepository.findByTitle(gameTitle)).isNull();
    }

}
