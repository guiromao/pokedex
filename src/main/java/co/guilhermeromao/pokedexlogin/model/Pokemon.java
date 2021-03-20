package co.guilhermeromao.pokedexlogin.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon extends Model {

    private String pokeName;
    private Integer level;

    @ManyToOne
    private Trainer trainer;

    public Pokemon(){

    }

    public Pokemon(String name, Integer level){
        pokeName = name;
        this.level = level;
    }

    @Override
    public String toString(){
        return "Pokemon: " + pokeName + ". Level: " + level + ".";
    }

    public String getPokeName(){
        return pokeName;
    }

    public Integer getLevel(){
        return level;
    }

    public Trainer getTrainer(){
        return trainer;
    }

    public void setPokeName(String name){
        this.pokeName = name;
    }

    public void setLevel(Integer level){
        this.level = level;
    }

    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }

}
