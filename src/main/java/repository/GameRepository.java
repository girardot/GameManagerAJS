package repository;

import javax.inject.Inject;

import java.util.List;

import model.Game;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;

@Repository
public class GameRepository extends HibernateDaoSupport {

    @Inject
    public GameRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Game findById(long id) {
        return (Game) getHibernateTemplate().get(Game.class, id);
    }

    public List<Game> findAll() {
        return getHibernateTemplate().find("from model.Game");
    }

    public Game findByTitle(String title) {
        return (Game)Iterables.getFirst(getHibernateTemplate().find("from model.Game g where lower(g.title)=lower(?)", title), null);
    }

    public void saveOrUpdate(Game game) {
        getHibernateTemplate().saveOrUpdate(game);
    }

    public void delete(Game game) {
        getHibernateTemplate().delete(game);
    }

    public List<Game> findByConsoleId(long consoleId) {
        return getHibernateTemplate().find("from model.Game g where g.console.id=?", consoleId);
    }

}
