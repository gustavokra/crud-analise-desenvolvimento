package org.acme.infra.database.mysql.model.pedido;

import org.acme.infra.database.mysql.model.produto.Produto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "pedido_item")
public class PedidoItem extends PanacheEntity {
    
    @Column(name = "id_pedido")
    private Pedido pedido;

    @Column(name = "id_produto")
    private Produto produto;

    @Column(name = "id_unidade_medida")
    private UnidadeMedida unidadeMedida;

}
