package jgt.repository;

import jgt.model.GameToBuy;
import org.json.JSONException;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class GameToBuyRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    GameToBuyRepository gameToBuyRepository;

    @Test
    public void should_find_all_games_to_buy_by_order() throws Exception {
        // Given / When
        List allGameToBuyByOrder = gameToBuyRepository.findAllByOrder();

        // Then
        assertThat(allGameToBuyByOrder).hasSize(2);
        assertThat(extractProperty("toBuyOrder").from(allGameToBuyByOrder)).containsExactly(1, 2);
        assertThat(extractProperty("game.title").from(allGameToBuyByOrder)).containsExactly("game to buy", "game to buy 2");
    }

    @Test
    public void should_add_a_new_game_to_buy() throws JSONException {
        // Given
        String newGameToBuyTitle = "new game to buy";
        GameToBuy newGameToBuy = new GameToBuy(newGameToBuyTitle);

        // When
        gameToBuyRepository.saveOrUpdate(newGameToBuy);

        // Then
        List allGameToBuyByOrder = gameToBuyRepository.findAllByOrder();  assertThat(allGameToBuyByOrder).hasSize(3);
        assertThat(extractProperty("game.title").from(allGameToBuyByOrder)).contains("game to buy", "game to buy 2", newGameToBuyTitle);
    }

    @Test
    public void should_delete_game_to_buy() throws Exception {
        // Given
        GameToBuy gameToBuyToDelete = gameToBuyRepository.findByTitle("game to buy");
        assertThat(gameToBuyToDelete.getId()).isNotNull();

        // When
        gameToBuyRepository.delete(gameToBuyToDelete.getId());

        // Then
        assertThat(gameToBuyRepository.findByTitle("game to buy")).isNull();
    }

    @Test
    public void should_delete_game_to_qsdbuy() throws Exception {
        // Given
        GameToBuy newGameToBuy = new GameToBuy("test");

        // When
        gameToBuyRepository.saveOrUpdate(newGameToBuy);

        // Then
        assertThat(gameToBuyRepository.findByTitle("test")).isNotNull();
    }

}
