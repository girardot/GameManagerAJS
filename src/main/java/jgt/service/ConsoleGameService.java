package jgt.service;

import jgt.model.Console;
import jgt.model.Game;
import jgt.model.GameProgression;
import jgt.repository.ConsoleRepository;
import jgt.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ConsoleGameService {

    @Inject
    private ConsoleRepository consoleRepository;

    @Inject
    private GameRepository gameRepository;

    @Inject
    private JsonConverter jsonConverter;

    public String findAll() {
        return jsonConverter.convertToJson(consoleRepository.findAll());
    }

    @Transactional
    public String saveConsole(String consoleJson) {
        Console console = new Console(consoleJson);
        consoleRepository.saveOrUpdate(console);
        return jsonConverter.convertToJson(console);
    }

    public String findGameByConsoleId(Long consoleId) {
        List games = gameRepository.findByConsoleId(consoleId);
        return jsonConverter.convertToJson(games);
    }

    @Transactional
    public String saveGame(String gameJson) {
        Game game = jsonConverter.convertJsonToGame(gameJson);
        gameRepository.saveOrUpdate(game);
        return jsonConverter.convertToJson(game);
    }

    @Transactional
    public Long deleteGame(Long gameId) {
        return gameRepository.delete(gameId);
    }

    @Transactional
    public Long deleteConsole(Long consoleId) {
        return consoleRepository.delete(consoleId);
    }

    @Transactional
    public String changeGameStatus(Long gameId, GameProgression gameProgression) {
        Game game = gameRepository.findById(gameId);
        game.setProgression(gameProgression);
        gameRepository.saveOrUpdate(game);
        return jsonConverter.convertToJson(game);
    }

    @Transactional
    public String toogleDematerialized(long gameId) {
        Game game = gameRepository.findById(gameId);
        game.toogleDematerialized();
        gameRepository.saveOrUpdate(game);
        return jsonConverter.convertToJson(game);
    }

}
