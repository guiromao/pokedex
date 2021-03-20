package co.guilhermeromao.pokedexlogin.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateTime;

    @Version
    private Integer version;

}
