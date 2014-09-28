package jgt.repository;

import com.google.common.collect.Iterables;
import jgt.model.GameToBuy;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class GameToBuyRepository extends HibernateDaoSupport{

    @Inject
    public GameToBuyRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public List findAllByOrder() {
        return currentSession().createCriteria(GameToBuy.class).addOrder(Order.asc("toBuyOrder")).list();
    }

    public void saveOrUpdate(GameToBuy gameToBuy) {
        getHibernateTemplate().saveOrUpdate(gameToBuy);
    }

    public void delete(long gameToBuyId) {
        GameToBuy gameToBuy = getHibernateTemplate().get(GameToBuy.class, gameToBuyId);
        getHibernateTemplate().delete(gameToBuy);
    }

    public GameToBuy findByTitle(String gameToBuyTitle) {
        return Iterables.getOnlyElement((Iterable<? extends GameToBuy>) getHibernateTemplate().find("from GameToBuy g where lower(g.game.title)=lower(?)", gameToBuyTitle), null);
    }

}
