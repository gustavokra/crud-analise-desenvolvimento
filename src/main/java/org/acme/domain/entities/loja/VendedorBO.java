package org.acme.domain.entities.loja;

import org.acme.domain.entities.endereco.EnderecoBO;

public class VendedorBO {
    
    private String name;

    private EnderecoBO enderecoBO;

    private LojaBO lojaBO;

    private boolean ativo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnderecoBO getEnderecoBO() {
        return enderecoBO;
    }
    
    public void setEnderecoBO(EnderecoBO enderecoBO) {
        this.enderecoBO = enderecoBO;
    }

    public LojaBO getLojaBO() {
        return lojaBO;
    }

    public void setLoja(LojaBO lojaBO) {
        this.lojaBO = lojaBO;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
