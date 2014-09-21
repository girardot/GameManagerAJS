package jgt.service;


import jgt.model.GameToBuy;
import jgt.repository.GameToBuyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class GameToBuyService {

    @Inject
    private JsonConverter jsonConverter;

    @Inject
    private GameToBuyRepository GameToBuyRepository;

    @Transactional(readOnly = true)
    public String findAllByOrder() {
        return jsonConverter.convertToJson(GameToBuyRepository.findAllByOrder());
    }

    @Transactional
    public String saveGameToBuy(String gameToBuyTitle) {
        GameToBuy gameToBuy = new GameToBuy(gameToBuyTitle);
        GameToBuyRepository.saveOrUpdate(gameToBuy);
        return jsonConverter.convertToJson(gameToBuy);
    }

}
