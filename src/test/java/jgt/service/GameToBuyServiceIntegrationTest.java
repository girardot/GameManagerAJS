package jgt.service;

import com.google.common.base.Predicate;
import jgt.model.GameToBuy;
import jgt.repository.AbstractIntegrationTest;
import jgt.repository.GameToBuyRepository;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.collect.Iterables.find;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class GameToBuyServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyService gameToBuyService;

    @Inject
    private GameToBuyRepository gameToBuyRepository;

    @Test
    public void should_change_game_to_buy_order() {
        // Given
        String userEmail = "girardot.jul@gmail.com";
        List<GameToBuy> allGameToBuyByOrder = gameToBuyRepository.findAllByOrder(userEmail);
        assertThat(allGameToBuyByOrder).hasSize(3);
        assertThat(extractProperty("toBuyOrder").from(allGameToBuyByOrder)).containsExactly(1, 2, 3);
        assertThat(extractProperty("game.title").from(allGameToBuyByOrder)).containsExactly("game to buy", "game to buy 2", "game to buy 3");

        // When
        find(allGameToBuyByOrder, gameToBuyNamePredicate("game to buy 3"));

        String newOrder = find(allGameToBuyByOrder, gameToBuyNamePredicate("game to buy 3")).getId()
                + "," + find(allGameToBuyByOrder, gameToBuyNamePredicate("game to buy")).getId()
                + "," + find(allGameToBuyByOrder, gameToBuyNamePredicate("game to buy 2")).getId();
        gameToBuyService.changeOrders(newOrder, userEmail);

        //Then
        List<GameToBuy> allGameToBuyWithNewOrder = gameToBuyRepository.findAllByOrder(userEmail);
        assertThat(allGameToBuyWithNewOrder).hasSize(3);
        assertThat(extractProperty("toBuyOrder").from(allGameToBuyWithNewOrder)).containsExactly(1, 2, 3);
        assertThat(extractProperty("game.title").from(allGameToBuyWithNewOrder)).containsExactly("game to buy 3", "game to buy", "game to buy 2");
    }

    private Predicate<GameToBuy> gameToBuyNamePredicate(String gameToBuyName) {
        return gameToBuy -> gameToBuy.getTitle().equals(gameToBuyName);
    }

}
