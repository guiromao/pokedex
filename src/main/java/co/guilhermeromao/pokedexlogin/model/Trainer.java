package co.guilhermeromao.pokedexlogin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer extends Model {

    private String trainerName;
    private String password;

    @OneToMany (
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            mappedBy = "trainer"
    )
    private List<Pokemon> pokemons;

    public Trainer(){

    }

    public Trainer(String name, String pass){
        trainerName = name;
        password = pass;
        pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
        pokemon.setTrainer(this);
    }

    public Integer getId(){
        return id;
    }

    public String getTrainerName(){
        return trainerName;
    }

    public String getPassword(){
        return  password;
    }

    public List<Pokemon> getPokemons(){
        return pokemons;
    }

    public void setTrainerName(String name){
        trainerName = name;
    }

    public void setPassword(String pass){
        password = pass;
    }

    public void setPokemons(List<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

}
