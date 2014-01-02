package repository;

import javax.inject.Inject;

import java.util.List;

import model.Console;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
        return getHibernateTemplate().find("from game.manager.model.Console");
    }

    public List<Console> findByName(String name) {
        return getHibernateTemplate().find("from game.manager.model.Console c where c.name=?", name);
    }


    public void saveOrUpdate(Console console) {
        getHibernateTemplate().saveOrUpdate(console);
    }

    public void delete(Console console) {
        getHibernateTemplate().delete(console);
    }

}
