package jgt.repository;

import javax.inject.Inject;

import java.util.List;

import jgt.model.Console;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;

@Repository
public class ConsoleRepository extends HibernateDaoSupport {

    @Inject
    public ConsoleRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Console findById(long id) {
        return (Console) getHibernateTemplate().get(Console.class, id);
    }

    public List<Console> findAll() {
        return getHibernateTemplate().find("from jgt.model.Console");
    }

    public Console findByName(String name) {
        return (Console)Iterables.getFirst(getHibernateTemplate().find("from jgt.model.Console c where lower(c.name)= lower(?)", name), null);
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
