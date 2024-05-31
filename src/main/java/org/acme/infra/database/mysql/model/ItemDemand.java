package org.acme.infra.database.mysql.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_order")
public class ItemDemand extends PanacheEntity implements Serializable {

    private Demand demand;

    private Product product;

    private UnitMeasure unitMeasure;

    private Long amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

}
