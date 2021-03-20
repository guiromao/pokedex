package co.guilhermeromao.pokedexlogin.services;

import co.guilhermeromao.pokedexlogin.dao.PokemonDao;
import co.guilhermeromao.pokedexlogin.dao.TrainerDao;
import co.guilhermeromao.pokedexlogin.dao.sessions.JpaTransactionManager;
import co.guilhermeromao.pokedexlogin.model.Pokemon;
import co.guilhermeromao.pokedexlogin.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface PokeService {

    Optional<Trainer> login(String username, String password);

    List<Pokemon> retrievePokemons(String username);

    void setPokemonDao(PokemonDao dao);

    void setTrainerDao(TrainerDao dao);

    void setTransactionManager(JpaTransactionManager manager);

}
