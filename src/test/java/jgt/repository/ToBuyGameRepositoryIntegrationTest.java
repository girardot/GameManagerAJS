package jgt.repository;

import jgt.model.GameToBuy;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class ToBuyGameRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private ToBuyGameRepository toBuyGameRepository;

    @Test
    public void should_find_all_games_to_buy() throws Exception {
        // When
        List allGameToBuy = toBuyGameRepository.findAllByOrder();

        // Then
        assertThat(allGameToBuy).hasSize(2);
        assertThat(extractProperty("game.title").from(allGameToBuy)).containsExactly("game to buy", "game to buy 2");

        GameToBuy firstGameToBuy = (GameToBuy) allGameToBuy.get(0);
        assertThat(firstGameToBuy.getToBuyOrder()).isEqualTo(1);

        GameToBuy secondGameToBuy = (GameToBuy) allGameToBuy.get(1);
        assertThat(secondGameToBuy.getToBuyOrder()).isEqualTo(2);
    }

}
