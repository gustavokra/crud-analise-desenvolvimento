package org.acme.infra.database.mysql.model.endereco;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Table;

@Table(name = "estado")
public class Estado extends PanacheEntity {
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
