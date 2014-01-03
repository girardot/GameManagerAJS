package repository;

import javax.inject.Inject;

import java.util.List;

import model.Game;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
        return getHibernateTemplate().find("from game.manager.model.Game");
    }

    public List<Game> findByTitle(String title) {
        return getHibernateTemplate().find("from game.manager.model.Game g where g.title=?", title);
    }

    public void save(Game game) {
        getHibernateTemplate().saveOrUpdate(game);
    }

    public void delete(Game game) {
        getHibernateTemplate().delete(game);
    }

}
