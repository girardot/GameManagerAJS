package jgt.service;

import jgt.model.Game;
import jgt.repository.GameToDoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class GameToDoService {

    @Inject
    private GameToDoRepository gameToDoRepository;

    @Transactional(readOnly = true)
    public List<Game> findAll(String userEmail) {
        return gameToDoRepository.findAll(userEmail);
    }

}

