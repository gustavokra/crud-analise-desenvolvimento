package com.kraemer.infra.database.mysql.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends PanacheEntity implements Serializable {
    
    @ManyToOne
    private City city;

    @ManyToOne
    private State state;
    
    @ManyToOne
    private Country country;

    private String street;

    private String number;

    private boolean active;

    

   

   

}
