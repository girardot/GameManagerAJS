package jgt.service;

import jgt.model.GameToBuy;
import jgt.repository.AbstractIntegrationTest;
import org.json.JSONException;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class ToBuyGameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyService toBuyGameService;

    @Test
    public void should_find_all_game_to_buy_in_order() throws JSONException {
        // Given
        String userEmail = "girardot.jul@gmail.com";

        // When
        List gamesToBuy = toBuyGameService.findAllByOrder(userEmail);

        // Then
        assertThat(gamesToBuy).hasSize(3);
        assertThat(extractProperty("toBuyOrder").from(gamesToBuy)).containsExactly(1, 2, 3);
        assertThat(extractProperty("game.title").from(gamesToBuy)).containsExactly("game to buy", "game to buy 2", "game to buy 3");
    }

    @Test
    public void should_add_a_new_game_to_buy() throws JSONException {
        // Given
        String userEmail = "girardot.jul@gmail.com";
        String newGameToBuyTitle = "new game to buy";

        // When
        GameToBuy gameToBuySaved = toBuyGameService.saveGameToBuy(newGameToBuyTitle, userEmail);

        // Then
        assertThat(gameToBuySaved).isNotNull();
        assertThat(gameToBuySaved.getTitle()).isEqualTo(newGameToBuyTitle);
    }

    @Test
    public void should_reorder_games_when_add_a_new_one() throws JSONException {
        // Given
        String userEmail = "girardot.jul@gmail.com";
        String newGameToBuyTitle = "new game to buy";

        // When
        toBuyGameService.saveGameToBuy(newGameToBuyTitle, userEmail);

        // Then
        List gamesToBuy = toBuyGameService.findAllByOrder(userEmail);
        assertThat(gamesToBuy).hasSize(4);
        assertThat(extractProperty("toBuyOrder").from(gamesToBuy)).containsExactly(1, 2, 3, 4);
        assertThat(extractProperty("game.title").from(gamesToBuy)).containsExactly(newGameToBuyTitle, "game to buy", "game to buy 2", "game to buy 3");
    }

}
