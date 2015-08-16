package jgt.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import jgt.model.Credentials;
import jgt.model.QCredentials;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthenticationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Credentials findCredentialsBy(String email) {
        QCredentials qCredentials = QCredentials.credentials;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(qCredentials).where(qCredentials.email.eq(email)).uniqueResult(qCredentials);
    }

    public List<Credentials> findAllCredentials() {
        QCredentials qCredentials = QCredentials.credentials;
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(qCredentials).list(qCredentials);
    }

}
