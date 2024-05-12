package org.acme.infra.database.mysql.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {

    public String descricao;

    public String cpfCnpj;

}
