package co.guilhermeromao.pokedexlogin.dao;

import co.guilhermeromao.pokedexlogin.dao.sessions.JpaSessionManager;
import co.guilhermeromao.pokedexlogin.dao.sessions.SessionManager;
import co.guilhermeromao.pokedexlogin.model.Trainer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public abstract class PokeDao<T> {

    protected JpaSessionManager sessionManager;
    protected Class<T> modelType;

    public PokeDao(Class<T> type){
        modelType = type;
    }

    public T saveOrUpdate(T object){
        return sessionManager.getCurrentSession().merge(object);
    }


    public List<T> listAll(){
        EntityManager em = sessionManager.getCurrentSession();

        return em.createQuery("from " + modelType.getSimpleName(), modelType).getResultList();
    }

    public void setSessionManager(JpaSessionManager sm){
        sessionManager = sm;
    }

}
