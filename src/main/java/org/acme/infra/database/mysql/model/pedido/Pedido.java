package org.acme.infra.database.mysql.model.pedido;

import java.io.Serializable;

import org.acme.infra.database.mysql.model.loja.Cliente;
import org.acme.infra.database.mysql.model.loja.Loja;
import org.acme.infra.database.mysql.model.loja.Vendedor;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ativo")
public class Pedido extends PanacheEntity implements Serializable {

    private Loja loja;

    private Cliente cliente;

    private Vendedor vendedor;

    private String status;

    private boolean ativo;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
