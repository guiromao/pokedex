package co.guilhermeromao.pokedexlogin.dao.sessions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaSessionManager implements SessionManager<EntityManager> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public JpaSessionManager(EntityManagerFactory emf) {
        entityManagerFactory = emf;
    }

    @Override
    public void startSession() {
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
    }

    @Override
    public void stopSession() {
        if (entityManager != null) {
            entityManager.close();
        }
        entityManager = null;
    }

    @Override
    public EntityManager getCurrentSession() {
        startSession();

        return entityManager;
    }

}
