package org.acme.domain.entities.produto;

import org.acme.domain.entities.loja.LojaBO;

public class EstoqueBO {
    
    private Long id;

    private String descricao;

    private LojaBO lojaBO;

    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LojaBO getLojaBO() {
        return lojaBO;
    }

    public void setLojaBO(LojaBO lojaBO) {
        this.lojaBO = lojaBO;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
}
