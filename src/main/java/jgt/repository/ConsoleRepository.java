package jgt.repository;

import com.google.common.collect.Iterables;
import jgt.model.Console;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ConsoleRepository extends HibernateDaoSupport {

    @Inject
    public ConsoleRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Console findById(long id) {
        return getHibernateTemplate().get(Console.class, id);
    }

    public List findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Console.class);
        return getHibernateTemplate().findByCriteria(criteria);
    }

    public Console findByName(String name) {
        Iterable consoles = getHibernateTemplate().find("from jgt.model.Console c where lower(c.name)= lower(?)", name);
        return (Console) Iterables.getFirst(consoles, null);
    }

    public void saveOrUpdate(Console console) {
        getHibernateTemplate().saveOrUpdate(console);
    }

    public void delete(Console console) {
        getHibernateTemplate().delete(console);
    }

    public Long delete(Long consoleId) {
        Console console = getHibernateTemplate().get(Console.class, consoleId);
        getHibernateTemplate().delete(console);
        return consoleId;
    }

}
