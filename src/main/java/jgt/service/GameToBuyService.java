package jgt.service;


import jgt.model.GameToBuy;
import jgt.repository.GameToBuyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class GameToBuyService {

    @Inject
    private GameToBuyRepository gameToBuyRepository;

    @Transactional(readOnly = true)
    public List findAllByOrder() {
        return gameToBuyRepository.findAllByOrder();
    }

    @Transactional
    public GameToBuy saveGameToBuy(String gameToBuyTitle) {
        GameToBuy gameToBuy = new GameToBuy(gameToBuyTitle);
        gameToBuyRepository.saveOrUpdate(gameToBuy);
        return gameToBuy;
    }

    @Transactional
    public long deleteGame(long gameToBuyId) {
        gameToBuyRepository.delete(gameToBuyId);
        return gameToBuyId;
    }

}
