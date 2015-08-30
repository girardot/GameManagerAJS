package jgt.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.Console;
import jgt.model.QConsole;
import jgt.model.QUser;
import jgt.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findByEmail(String email) {
        QUser user = QUser.user;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(user).where(user.email.equalsIgnoreCase(email)).uniqueResult(user);
    }

}
