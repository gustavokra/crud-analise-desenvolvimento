package org.acme.domain.entities.produto;

public class ProdutoBO {
    
    private EstoqueBO estoqueBO;

    private String descricao;

    private boolean ativo;

    public EstoqueBO getEstoqueBO() {
        return estoqueBO;
    }

    public void setEstoqueBO(EstoqueBO estoqueBO) {
        this.estoqueBO = estoqueBO;
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
