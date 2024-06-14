package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumOrderStatus;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class DemandBO extends CrudBO {

    private UserBO userBO;

    private ClientBO clientBO;

    private SellerBO sellerBO;

    private EnumOrderStatus status;

    private boolean active;

    public DemandBO(Long id, UserBO userBO, ClientBO clientBO, SellerBO sellerBO, EnumOrderStatus status,
            boolean active,
            CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.userBO = userBO;
        this.clientBO = clientBO;
        this.sellerBO = sellerBO;
        this.status = status;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public ClientBO getClientBO() {
        return clientBO;
    }

    public SellerBO getSellerBO() {
        return sellerBO;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public boolean isActive() {
        return active;
    }

}
