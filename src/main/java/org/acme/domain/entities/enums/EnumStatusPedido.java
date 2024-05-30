package org.acme.domain.entities.enums;

public enum EnumStatusPedido {
    
    ATV("Ativo", "ATV");

    private EnumStatusPedido(String descricao, String abreviacao) {
        this.descricao = descricao;
        this.abreviacao = abreviacao;
    }

    private String descricao;

    private String abreviacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    

}
