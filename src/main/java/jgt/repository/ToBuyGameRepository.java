package jgt.repository;

import jgt.model.Console;
import jgt.model.GameToBuy;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
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

    public List findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(GameToBuy.class);
        return getHibernateTemplate().findByCriteria(criteria);
    }

}
