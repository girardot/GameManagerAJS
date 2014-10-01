package jgt.repository;

import com.google.common.collect.Iterables;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.Console;
import jgt.model.Game;
import jgt.model.QConsole;
import jgt.model.QGame;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Game findById(long id) {
        QGame game = QGame.game;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(game).where(game.id.eq(id)).uniqueResult(game);
    }

    public Game findByTitle(String title) {
        QGame game = QGame.game;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(game).where(game.title.equalsIgnoreCase(title)).uniqueResult(game);
    }

    public void saveOrUpdate(Game game) {
        entityManager.persist(game);
    }

    public Long delete(Long gameId) {
        QGame game = QGame.game;
        new JPADeleteClause(entityManager, game).where(game.id.eq(gameId)).execute();
        return gameId;
    }

    public List<Game> findByConsoleId(long consoleId) {
        QGame game = QGame.game;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(game).where(game.console.id.eq(consoleId)).list(game);
    }

}
