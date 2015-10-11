package jgt.service;

import jgt.model.Game;
import jgt.model.GameProgression;
import jgt.repository.AbstractIntegrationTest;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;

import static jgt.model.GameProgression.*;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;
import static org.junit.Assert.*;

public class GameToDoServiceTest extends AbstractIntegrationTest {

    @Inject
    private GameToDoService gameToDoService;

    @Test
    public void should_find_all_games_to_do() {
        // Given
        String userEmail = "girardot.jul@gmail.com";

        // When
        List<Game> allGamesToDo = gameToDoService.findAll(userEmail);

        //Then
        assertThat(allGamesToDo).hasSize(2);
        assertThat(extractProperty("progression").from(allGamesToDo)).containsOnly(TO_DO);
        assertThat(extractProperty("console.user.email").from(allGamesToDo)).containsOnly(userEmail);
    }

}