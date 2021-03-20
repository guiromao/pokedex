package co.guilhermeromao.pokedexlogin.dao.sessions;

public interface SessionManager<T> {

    void startSession();

    void stopSession();

    T getCurrentSession();

}
