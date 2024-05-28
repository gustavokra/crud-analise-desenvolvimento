package org.acme.infra.database.mysql.model.produto;

import org.acme.infra.database.mysql.model.loja.Loja;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "estoque")
public class Estoque extends PanacheEntity {
    
    private String descricao;

    @Column(name = "id_loja")
    private Loja loja;

    private boolean ativo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
