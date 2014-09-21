package jgt.repository;

import jgt.model.GameToBuy;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class GameToBuyRepository extends HibernateDaoSupport {

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

}
