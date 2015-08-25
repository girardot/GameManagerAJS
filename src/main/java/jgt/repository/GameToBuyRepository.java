package jgt.repository;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.GameToBuy;
import jgt.model.QGameToBuy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GameToBuyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static QGameToBuy gameToBuy = QGameToBuy.gameToBuy;

    public List<GameToBuy> findAllByOrder(String userEmail) {
        JPAQuery query = new JPAQuery(entityManager);
        return query
                .from(gameToBuy)
                .where(gameToBuy.user.email.eq(userEmail))
                .orderBy(gameToBuy.toBuyOrder.asc()).list(gameToBuy);
    }

    public void saveOrUpdate(GameToBuy gameToBuy) {
        entityManager.persist(gameToBuy);
    }

    public void delete(long gameToBuyId) {
        new JPADeleteClause(entityManager, gameToBuy).where(gameToBuy.id.eq(gameToBuyId)).execute();
    }

    public GameToBuy findByTitle(String gameToBuyTitle) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(gameToBuy).where(gameToBuy.game.title.equalsIgnoreCase(gameToBuyTitle)).uniqueResult(gameToBuy);
    }

    public List<GameToBuy> findAll(String userEmail) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(gameToBuy).where(gameToBuy.user.email.eq(userEmail)).list(gameToBuy);
    }

}
