package jgt.service;

import javax.inject.Inject;

import jgt.model.Game;
import jgt.repository.AbstractIntegrationTest;
import jgt.repository.GameRepository;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class GameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameRepository gameRepository;

    @Test
    public void should_add_new_game() {
        // Given
        Game game = new Game("new game");

        // When
        gameRepository.saveOrUpdate(game);

        //Then
        Game gameResult = gameRepository.findByTitle("new game");
        Assertions.assertThat(gameResult.getTitle()).isEqualTo("new game");
    }

    @Test
    public void should_find_game_by_title() {
        // When
        Game gameResult = gameRepository.findByTitle("Call of duty");

        //Then
        Assertions.assertThat(gameResult.getTitle()).isEqualTo("call of duty");
    }

}
