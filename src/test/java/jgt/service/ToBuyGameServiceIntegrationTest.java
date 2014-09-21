package jgt.service;

import jgt.repository.AbstractIntegrationTest;
import org.fest.assertions.api.Assertions;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.*;

public class ToBuyGameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameToBuyService toBuyGameService;

    @Test
    public void should_find_all_game_to_buy_in_order() throws JSONException {
        // Given / When
        String gamesToBuyInJson = toBuyGameService.findAllByOrder();

        // Then
        String s = "[{\"to_buy_order\":1,\"title\":\"game to buy\"},{\"to_buy_order\":2,\"title\":\"game to buy 2\"}]";
        JSONAssert.assertEquals(s, gamesToBuyInJson, false);
    }

    @Test
    public void should_add_a_new_game_to_buy() throws JSONException {
        // Given
        String newGameToBuyTitle = "new game to buy";

        // When
        String gameToBuySaved = toBuyGameService.saveGameToBuy(newGameToBuyTitle);

        // Then
        JSONAssert.assertEquals("{\"title\":\"new game to buy\"}", gameToBuySaved, false);
    }

}
