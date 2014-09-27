package jgt.service;

import jgt.model.GameToBuy;
import jgt.repository.AbstractIntegrationTest;
import org.fest.assertions.api.Assertions;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.inject.Inject;

import java.util.List;

import static org.fest.assertions.api.Assertions.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class ToBuyGameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyService toBuyGameService;

    @Test
    public void should_find_all_game_to_buy_in_order() throws JSONException {
        // Given / When
        List gamesToBuy = toBuyGameService.findAllByOrder();

        // Then
        assertThat(gamesToBuy).hasSize(2);
        assertThat(extractProperty("toBuyOrder").from(gamesToBuy)).containsExactly(1, 2);
        assertThat(extractProperty("game.title").from(gamesToBuy)).containsExactly("game to buy", "game to buy 2");
    }

    @Test
    public void should_add_a_new_game_to_buy() throws JSONException {
        // Given
        String newGameToBuyTitle = "new game to buy";

        // When
        GameToBuy gameToBuySaved = toBuyGameService.saveGameToBuy(newGameToBuyTitle);

        // Then
        assertThat(gameToBuySaved).isNotNull();
//        assertThat(gameToBuySaved.getToBuyOrder()).isEqualTo(3);
        assertThat(gameToBuySaved.getTitle()).isEqualTo(newGameToBuyTitle);
    }

}
