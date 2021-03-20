package co.guilhermeromao.pokedexlogin.controllers;

import co.guilhermeromao.pokedexlogin.model.Trainer;
import co.guilhermeromao.pokedexlogin.services.PokeService;
import co.guilhermeromao.pokedexlogin.views.LoginView;

import java.util.Optional;

public interface LoginController {

    void init();

    Optional<Trainer> login(String username, String password);

    void setView(LoginView view);

    void setService(PokeService service);

}
