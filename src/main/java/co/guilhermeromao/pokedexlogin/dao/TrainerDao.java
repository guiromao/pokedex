package co.guilhermeromao.pokedexlogin.dao;

import co.guilhermeromao.pokedexlogin.model.Trainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class TrainerDao extends PokeDao<Trainer> {

    public TrainerDao() {
        super(Trainer.class);
    }

    public Optional<Trainer> login(String username, String password){
        Optional<Trainer> trainer = get(username);

        if(trainer.isPresent()){
            if(trainer.get().getPassword().equals(password)){
                return trainer;
            }
        }

        return null;
    }

    public Optional<Trainer> get(String username){
        EntityManager em = sessionManager.getCurrentSession();
        TypedQuery<Trainer> query = em.createQuery("SELECT trainer FROM Trainer trainer WHERE " +
                "trainer.trainerName=:string", Trainer.class);

        query.setParameter("string", username);

        List<Trainer> listResults = query.getResultList();

        Trainer trainer = listResults.size() > 0 ? listResults.get(0) : null;

        Optional<Trainer> result = Optional.ofNullable(trainer);

        return result;
    }

    public void delete(String username){
        EntityManager em = sessionManager.getCurrentSession();

        TypedQuery<Trainer> query = em.createQuery("SELECT trainer FROM Trainer trainer WHERE " +
                "trainer.trainerName=:string", Trainer.class);

        Trainer trainer = query.getSingleResult();

        em.remove(trainer.getId());
    }

}
