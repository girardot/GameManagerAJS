package jgt.repository;

import jgt.model.GameToBuy;
import jgt.model.User;
import org.json.JSONException;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class GameToBuyRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyRepository gameToBuyRepository;

    @Inject
    private UserRepository userRepository;

    private User user;

    @Override
    @org.junit.Before
    public void setUp() throws Exception {
        super.setUp();
        user = userRepository.findByEmail("girardot.jul@gmail.com");
    }

    @Test
    public void should_find_all_games_to_buy_by_order() throws Exception {
        // Given / When
        List allGameToBuyByOrder = gameToBuyRepository.findAllByOrder(user.getEmail());

        // Then
        assertThat(allGameToBuyByOrder).hasSize(3);
        assertThat(extractProperty("toBuyOrder").from(allGameToBuyByOrder)).containsExactly(1, 2, 3);
        assertThat(extractProperty("game.title").from(allGameToBuyByOrder)).containsExactly("game to buy", "game to buy 2", "game to buy 3");
    }

    @Test
    public void shoudl_find_all_game_to_buy_for_a_user() {
        // Given
        String userEmail1 = "girardot.jul@gmail.com";

        // When
        List<GameToBuy> gamesToBuy = gameToBuyRepository.findAllByOrder(userEmail1);

        // Then
        assertThat(extractProperty("user.email").from(gamesToBuy)).containsOnly(userEmail1);
    }

    @Test
    public void shoudl_find_all_game_to_buy_for_an_other_user() {
        // Given
        String userEmail = "seb@gmail.com";

        // When
        List<GameToBuy> gamesToBuy = gameToBuyRepository.findAllByOrder(userEmail);

        // Then
        assertThat(extractProperty("user.email").from(gamesToBuy)).containsOnly(userEmail);
    }

    @Test
    public void should_add_a_new_game_to_buy() throws JSONException {
        // Given
        String newGameToBuyTitle = "new game to buy";
        GameToBuy newGameToBuy = new GameToBuy(newGameToBuyTitle, user);

        // When
        gameToBuyRepository.saveOrUpdate(newGameToBuy);

        // Then
        List allGameToBuyByOrder = gameToBuyRepository.findAllByOrder(user.getEmail());
        assertThat(allGameToBuyByOrder).hasSize(4);
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
        GameToBuy newGameToBuy = new GameToBuy("test", user);

        // When
        gameToBuyRepository.saveOrUpdate(newGameToBuy);

        // Then
        assertThat(gameToBuyRepository.findByTitle("test")).isNotNull();
    }

}
