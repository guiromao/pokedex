package co.guilhermeromao.pokedexlogin.dao.sessions;

public class JpaTransactionManager implements TransactionManager {

    private JpaSessionManager sessionManager;

    @Override
    public void beginWrite() {
        sessionManager.startSession();
        sessionManager.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void beginRead() {
        sessionManager.startSession();
    }

    @Override
    public void commit() {
        if(sessionManager.getCurrentSession().getTransaction().isActive()){
            sessionManager.getCurrentSession().getTransaction().commit();
        }
        sessionManager.stopSession();
    }

    @Override
    public void rollback() {
        if(sessionManager.getCurrentSession().getTransaction().isActive()){
            sessionManager.getCurrentSession().getTransaction().rollback();
        }
        sessionManager.stopSession();
    }

    public void setSessionManager(JpaSessionManager sm){
        sessionManager = sm;
    }

}
