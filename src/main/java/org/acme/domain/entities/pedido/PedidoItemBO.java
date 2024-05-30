package org.acme.domain.entities.pedido;

import org.acme.domain.entities.produto.ProdutoBO;

public class PedidoItemBO {
    
    private PedidoBO pedidoBO;

    private ProdutoBO produtoBO;

    private UnidadeMedidaBO unidadeMedidaBO;

    private Integer quantidade;

    public PedidoBO getPedidoBO() {
        return pedidoBO;
    }

    public void setPedidoBO(PedidoBO pedidoBO) {
        this.pedidoBO = pedidoBO;
    }

    public ProdutoBO getProdutoBO() {
        return produtoBO;
    }

    public void setProdutoBO(ProdutoBO produtoBO) {
        this.produtoBO = produtoBO;
    }

    public UnidadeMedidaBO getUnidadeMedidaBO() {
        return unidadeMedidaBO;
    }

    public void setUnidadeMedidaBO(UnidadeMedidaBO unidadeMedidaBO) {
        this.unidadeMedidaBO = unidadeMedidaBO;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
