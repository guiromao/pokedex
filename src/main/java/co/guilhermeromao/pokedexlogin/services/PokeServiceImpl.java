package co.guilhermeromao.pokedexlogin.services;

import co.guilhermeromao.pokedexlogin.dao.PokemonDao;
import co.guilhermeromao.pokedexlogin.dao.TrainerDao;
import co.guilhermeromao.pokedexlogin.dao.sessions.JpaTransactionManager;
import co.guilhermeromao.pokedexlogin.model.Model;
import co.guilhermeromao.pokedexlogin.model.Pokemon;
import co.guilhermeromao.pokedexlogin.model.Trainer;

import javax.persistence.RollbackException;
import java.util.List;
import java.util.Optional;

public class PokeServiceImpl<T extends Model> implements PokeService{

    private JpaTransactionManager transactionManager;
    private PokemonDao pokemonDao;
    private TrainerDao trainerDao;

    @Override
    public Optional<Trainer> login(String username, String password) {
        transactionManager.beginRead();

        Optional<Trainer> result = trainerDao.login(username, password);

        transactionManager.commit();

        return result;
    }

    @Override
    public List<Pokemon> retrievePokemons(String username) {
        transactionManager.beginRead();
        List<Pokemon> list = pokemonDao.listAll();
        transactionManager.commit();

        return list;
    }

    public void saveTrainer(Trainer trainer){

        transactionManager.beginWrite();

        try {
            trainerDao.saveOrUpdate(trainer);
            transactionManager.commit();
        }
        catch(RollbackException e){
            transactionManager.rollback();
        }
    }

    public void savePokemon(Pokemon pokemon){

        transactionManager.beginWrite();

        try {
            pokemonDao.saveOrUpdate(pokemon);
            transactionManager.commit();
        }
        catch(RollbackException e){
            transactionManager.rollback();
        }
    }

    @Override
    public void setPokemonDao(PokemonDao dao){
        pokemonDao = dao;
    }

    @Override
    public void setTrainerDao(TrainerDao dao){
        trainerDao = dao;
    }

    @Override
    public void setTransactionManager(JpaTransactionManager manager){
        transactionManager = manager;
    }

}
