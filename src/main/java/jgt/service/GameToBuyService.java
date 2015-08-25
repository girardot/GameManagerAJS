package jgt.service;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import jgt.model.GameToBuy;
import jgt.model.User;
import jgt.repository.GameToBuyRepository;
import jgt.repository.UserRepository;
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

    private UserRepository userRepository;

    @Inject
    public GameToBuyService(GameToBuyRepository gameToBuyRepository, UserRepository userRepository) {
        this.gameToBuyRepository = gameToBuyRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List findAllByOrder(String userEmail) {
        return gameToBuyRepository.findAllByOrder(userEmail);
    }

    @Transactional
    public GameToBuy saveGameToBuy(String gameToBuyTitle, String userEmail) {
        List<GameToBuy> allGameToBuy = gameToBuyRepository.findAllByOrder(userEmail);
        allGameToBuy.forEach(GameToBuy::increaseOrder);

        User user = userRepository.findByEmail(userEmail);
        GameToBuy gameToBuy = new GameToBuy(gameToBuyTitle, user);
        gameToBuyRepository.saveOrUpdate(gameToBuy);
        return gameToBuy;
    }

    @Transactional
    public long deleteGame(long gameToBuyId) {
        gameToBuyRepository.delete(gameToBuyId);
        return gameToBuyId;
    }

    @Transactional
    public boolean changeOrders(String stringIdsByOrder) {
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
