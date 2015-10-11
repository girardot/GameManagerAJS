package jgt.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.Game;
import jgt.model.QGame;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static jgt.model.GameProgression.TO_DO;

@Repository
public class GameToDoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static QGame gameToDo = QGame.game;

    public List<Game> findAll(String userEmail) {
        JPAQuery query = new JPAQuery(entityManager);
        return query
                .from(gameToDo)
                .where(gameToDo.console.user.email.equalsIgnoreCase(userEmail))
                .where(gameToDo.progression.eq(TO_DO))
                .list(gameToDo);
    }

}
