package jgt.repository;

import com.google.common.collect.Iterables;
import jgt.model.Game;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class GameRepository extends HibernateDaoSupport {

    @Inject
    public GameRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Game findById(long id) {
        return getHibernateTemplate().get(Game.class, id);
    }

    public List findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Game.class);
        return getHibernateTemplate().findByCriteria(criteria);
    }

    public Game findByTitle(String title) {
        return Iterables.getFirst((Iterable<? extends Game>) getHibernateTemplate().find("from jgt.model.Game g where lower(g.title)=lower(?)", title), null);
    }

    public void saveOrUpdate(Game game) {
        getHibernateTemplate().saveOrUpdate(game);
    }

    public void delete(Game game) {
        getHibernateTemplate().delete(game);
    }

    public Long delete(Long gameId) {
        Game game = getHibernateTemplate().get(Game.class, gameId);
        getHibernateTemplate().delete(game);
        return gameId;
    }

    public List findByConsoleId(long consoleId) {
        return getHibernateTemplate().find("from jgt.model.Game g where g.console.id=? order by id", consoleId);
    }

}
