package co.guilhermeromao.pokedexlogin.controllers;

import co.guilhermeromao.pokedexlogin.model.Trainer;
import co.guilhermeromao.pokedexlogin.services.PokeService;
import co.guilhermeromao.pokedexlogin.views.LoginView;

import java.util.Optional;

public class LoginControllerImpl implements LoginController {

    private LoginView loginView;
    private PokeService pokeService;

    @Override
    public void init() {
        loginView.show();
    }

    @Override
    public Optional<Trainer> login(String username, String password) {
        return pokeService.login(username, password);
    }

    @Override
    public void setView(LoginView loginView){
        this.loginView = loginView;
    }

    public void setService(PokeService service){
        pokeService = service;
    }

}
