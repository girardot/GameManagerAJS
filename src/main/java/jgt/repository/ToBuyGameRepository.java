package jgt.repository;

import jgt.model.GameToBuy;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ToBuyGameRepository extends HibernateDaoSupport {

    @Inject
    public ToBuyGameRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public List findAllByOrder() {
        return currentSession().createCriteria(GameToBuy.class).addOrder(Order.asc("toBuyOrder")).list();
    }

}
