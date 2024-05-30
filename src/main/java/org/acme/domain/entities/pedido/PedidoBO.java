package org.acme.domain.entities.pedido;

import org.acme.domain.entities.loja.ClienteBO;
import org.acme.domain.entities.loja.LojaBO;
import org.acme.domain.entities.loja.VendedorBO;

public class PedidoBO {
    
    private LojaBO lojaBO;

    private ClienteBO clienteBO;

    private VendedorBO vendedorBO;

    private String status;

    private boolean ativo;

    public LojaBO getLojaBO() {
        return lojaBO;
    }

    public void setLojaBO(LojaBO lojaBO) {
        this.lojaBO = lojaBO;
    }

    public ClienteBO getClienteBO() {
        return clienteBO;
    }

    public void setClienteBO(ClienteBO clienteBO) {
        this.clienteBO = clienteBO;
    }

    public VendedorBO getVendedorBO() {
        return vendedorBO;
    }

    public void setVendedorBO(VendedorBO vendedorBO) {
        this.vendedorBO = vendedorBO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
