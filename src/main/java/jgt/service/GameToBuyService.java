package jgt.service;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import jgt.model.GameToBuy;
import jgt.repository.GameToBuyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameToBuyService {

    private static Logger logger = LoggerFactory.getLogger(GameToBuyService.class);

    private GameToBuyRepository gameToBuyRepository;

    @Inject
    public GameToBuyService(GameToBuyRepository gameToBuyRepository) {
        this.gameToBuyRepository = gameToBuyRepository;
    }

    @Transactional(readOnly = true)
    public List findAllByOrder() {
        return gameToBuyRepository.findAllByOrder();
    }

    @Transactional
    public GameToBuy saveGameToBuy(String gameToBuyTitle) {
        List<GameToBuy> allGameToBuy = gameToBuyRepository.findAllByOrder();
        allGameToBuy.forEach(GameToBuy::increaseOrder);

        GameToBuy gameToBuy = new GameToBuy(gameToBuyTitle);
        gameToBuyRepository.saveOrUpdate(gameToBuy);
        return gameToBuy;
    }

    @Transactional
    public long deleteGame(long gameToBuyId) {
        gameToBuyRepository.delete(gameToBuyId);
        return gameToBuyId;
    }

    @Transactional
    public boolean changerOrders(String stringIdsByOrder) {
        List<GameToBuy> allGameToBuy = gameToBuyRepository.findAll();

        List<Long> idsByOrder = Lists.newArrayList(Splitter.on(",").split(stringIdsByOrder))
                .stream().map(Long::parseLong).collect(Collectors.toList());

        Ordering<GameToBuy> expectedOrder = new Ordering<GameToBuy>() {
            public int compare(GameToBuy gameToBuy, GameToBuy gameToBuy2) {
                return Ordering.explicit(idsByOrder).compare(gameToBuy.getId(), gameToBuy2.getId());
            }
        };

        Collections.sort(allGameToBuy, expectedOrder);
        Integer i = 1;
        for (GameToBuy gameToBuy : allGameToBuy) {
            gameToBuy.setToBuyOrder(i);
            i++;
        }

        return true;
    }

}
