package com.kraemer.infra.database.mysql.model;

import java.io.Serializable;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "crud_address")
public class MySqlAddress extends CrudModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private MySqlCity city;

    @ManyToOne(cascade = CascadeType.ALL)
    private MySqlState state;

    @ManyToOne(cascade = CascadeType.ALL)
    private MySqlCountry country;

    private String neighborhood;

    private String street;

    private String number;

}
