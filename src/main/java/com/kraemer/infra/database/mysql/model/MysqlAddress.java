package com.kraemer.infra.database.mysql.model;

import java.io.Serializable;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
public class MysqlAddress extends CrudModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MysqlCity city;

    @ManyToOne
    private MysqlState state;

    @ManyToOne
    private MysqlCountry country;

    private String neighborhood;

    private String street;

    private String number;

}
