package jgt.service;

import jgt.repository.AbstractIntegrationTest;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.*;

public class ToBuyGameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyService toBuyGameService;

    @Test
    public void should_find_all_game_to_buy_in_order() {
        // Given

        // When
        String GamesToBuyInJson = toBuyGameService.findAllByOrder();

        // Then
        assertThat(GamesToBuyInJson).isEqualTo("[{\"id\":8,\"to_buy_order\":1,\"title\":\"game to buy\"},{\"id\":7,\"to_buy_order\":2,\"title\":\"game to buy 2\"}]");
    }

}
