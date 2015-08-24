package jgt.repository;

import jgt.model.Console;
import jgt.model.Game;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.groups.Properties.extractProperty;

public class ConsoleRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private ConsoleRepository consoleRepository;

    @Test
    public void should_add_new_console() {
        // Given
        Console console = new Console("new console");

        // When
        consoleRepository.saveOrUpdate(console);

        //Then
        Console consoleResult = consoleRepository.findByName("new console");
        assertThat(consoleResult.getName()).isEqualTo("new console");
    }

    @Test
    public void should_add_console_and_games() {
        // Given
        Console console = new Console("ps3-test");
        console.addGame(new Game("Call of duty"));
        console.addGame(new Game("Call of duty 2"));
        console.addGame(new Game("Call of duty 3"));

        // When
        consoleRepository.saveOrUpdate(console);

        // Then
        Console consoleResult = consoleRepository.findByName("ps3-test");

        assertThat(consoleResult.getName()).isEqualTo("ps3-test");
        assertThat(extractProperty("title").from(consoleResult.getGames())).contains("Call of duty", "Call of duty 2", "Call of duty 3");
    }

    @Test
    public void should_find_console_by_name_and_games() {
        // When
        Console console = consoleRepository.findByName("PS2");

        // Then
        assertThat(console.getName()).isEqualTo("ps2");
        assertThat(extractProperty("title").from(console.getGames())).contains("gta3", "nhl 2004");
    }

    @Test
    public void shoudl_find_all_console_for_a_user() {
        // Given
        String userEmail1 = "girardot.jul@gmail.com";

        // When
        List<Console> consoles = consoleRepository.findAll(userEmail1);

        // Then
        assertThat(extractProperty("user.email").from(consoles)).containsOnly(userEmail1);
    }

    @Test
    public void shoudl_find_all_console_for_an_other_user() {
        // Given
        String userEmail = "seb@gmail.com";

        // When
        List<Console> consoles = consoleRepository.findAll(userEmail);

        // Then
        assertThat(extractProperty("user.email").from(consoles)).containsOnly(userEmail);
    }

}
