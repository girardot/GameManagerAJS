package jgt.repository;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.Console;
import jgt.model.QConsole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConsoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Console findById(long id) {
        QConsole console = QConsole.console;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(console).where(console.id.eq(id)).uniqueResult(console);
    }

    public List<Console> findAll(String userEmail) {
        QConsole console = QConsole.console;
        JPAQuery query = new JPAQuery(entityManager);
        return query
                .from(console)
                .where(console.user.email.equalsIgnoreCase(userEmail))
                .list(console);
    }

    public Console findByName(String name) {
        QConsole console = QConsole.console;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(console).where(console.name.equalsIgnoreCase(name)).uniqueResult(console);
    }

    public void saveOrUpdate(Console console) {
        entityManager.persist(console);
    }

    public Long delete(Long consoleId) {
        QConsole console = QConsole.console;
        new JPADeleteClause(entityManager, console).where(console.id.eq(consoleId)).execute();
        return consoleId;
    }

}
