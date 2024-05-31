package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.enums.EnumOrderStatus;
import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class DemandBO implements ICrudBO {

    private Long id;

    private UserBO userBO;

    private ClientBO clientBO;

    private SellerBO sellerBO;

    private EnumOrderStatus status;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public DemandBO(Long id, UserBO userBO, ClientBO clientBO, SellerBO sellerBO, EnumOrderStatus status, boolean active,
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

    public Long getId() {
        return id;
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

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

}
