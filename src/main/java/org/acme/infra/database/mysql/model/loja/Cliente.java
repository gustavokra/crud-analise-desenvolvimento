package org.acme.infra.database.mysql.model.loja;

import org.acme.infra.database.mysql.model.endereco.Endereco;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "cliente")
public class Cliente extends PanacheEntity {
    
    private String name;

    @Column(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "id_loja")
    private Loja loja;

    private boolean ativo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
