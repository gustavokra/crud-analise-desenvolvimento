package org.acme.infra.database.mysql.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends PanacheEntity implements Serializable {
    
    private City city;

    private State state;
    
    private Country country;

    private String street;

    private String number;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

}
