package co.guilhermeromao.pokedexlogin.app;

import co.guilhermeromao.pokedexlogin.controllers.LoginController;
import co.guilhermeromao.pokedexlogin.controllers.LoginControllerImpl;
import co.guilhermeromao.pokedexlogin.dao.PokemonDao;
import co.guilhermeromao.pokedexlogin.dao.TrainerDao;
import co.guilhermeromao.pokedexlogin.dao.sessions.JpaSessionManager;
import co.guilhermeromao.pokedexlogin.dao.sessions.JpaTransactionManager;
import co.guilhermeromao.pokedexlogin.model.Pokemon;
import co.guilhermeromao.pokedexlogin.model.Trainer;
import co.guilhermeromao.pokedexlogin.services.PokeServiceImpl;
import co.guilhermeromao.pokedexlogin.views.LoginView;
import co.guilhermeromao.pokedexlogin.views.LoginViewImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("poke");
        EntityManager em = emf.createEntityManager();

        Trainer trainer1 = new Trainer("Guilherme", "howdy2021");
        Trainer trainer2 = new Trainer("Ash", "Pikachu1999");

        Pokemon poke1 = new Pokemon("Charizard", 40);
        Pokemon poke2 = new Pokemon("Electabuzz", 99);
        Pokemon poke3 = new Pokemon("Pikachu", 22);
        Pokemon poke4 = new Pokemon("Onix", 20);

        trainer1.addPokemon(poke1);
        trainer1.addPokemon(poke2);

        trainer2.addPokemon(poke3);
        trainer2.addPokemon(poke4);

        JpaSessionManager sessionManager = new JpaSessionManager(emf);
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setSessionManager(sessionManager);

        LoginController loginController = new LoginControllerImpl();

        LoginView loginView = new LoginViewImpl();
        loginController.setView(loginView);
        loginView.setController(loginController);

        PokeServiceImpl pokeService = new PokeServiceImpl();
        loginController.setService(pokeService);

        TrainerDao trainerDao = new TrainerDao();
        PokemonDao pokemonDao = new PokemonDao();

        pokeService.setTrainerDao(trainerDao);
        pokeService.setPokemonDao(pokemonDao);

        pokeService.setTransactionManager(transactionManager);

        trainerDao.setSessionManager(sessionManager);
        pokemonDao.setSessionManager(sessionManager);

        pokeService.saveTrainer(trainer1);
        pokeService.saveTrainer(trainer2);

        System.out.println(poke1.toString());

        pokeService.savePokemon(poke1);
        pokeService.savePokemon(poke2);
        pokeService.savePokemon(poke3);
        pokeService.savePokemon(poke4);

        loginController.init();

    }

}
