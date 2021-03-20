package co.guilhermeromao.pokedexlogin.dao;

import co.guilhermeromao.pokedexlogin.model.Pokemon;

public class PokemonDao extends PokeDao<Pokemon> {

    public PokemonDao() {
        super(Pokemon.class);
    }

}
