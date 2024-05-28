package org.acme.infra.database.mysql.model.pedido;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Table;

@Table(name = "unidade_medida")
public class UnidadeMedida extends PanacheEntity {
    
    private String sigla;

    private String descricao;

    private boolean ativo;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
