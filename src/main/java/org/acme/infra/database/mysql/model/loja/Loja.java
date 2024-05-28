package org.acme.infra.database.mysql.model.loja;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Table;

@Table(name = "loja")
public class Loja extends PanacheEntity {
    
    private String nome;

    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    

}
