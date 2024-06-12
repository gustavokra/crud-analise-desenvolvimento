package com.kraemer.infra.database.mysql.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumOrderStatus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Demand extends PanacheEntity implements Serializable {

    private MySqlUser user;

    private Client client;

    private Seller seller;

    private EnumOrderStatus status;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

}
