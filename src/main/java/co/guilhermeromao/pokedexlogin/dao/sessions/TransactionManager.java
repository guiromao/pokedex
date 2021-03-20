package co.guilhermeromao.pokedexlogin.dao.sessions;

public interface TransactionManager {

    void beginWrite();

    void beginRead();

    void commit();

    void rollback();

}
