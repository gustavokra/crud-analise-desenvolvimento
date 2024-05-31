package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.enums.EnumOrderStatus;
import org.acme.domain.entities.vo.CreatedAtVO;

public class OrderBO {

    private StoreBO storeBO;

    private ClientBO clientBO;

    private SellerBO sellerBO;

    private EnumOrderStatus status;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public OrderBO(StoreBO storeBO, ClientBO clientBO, SellerBO sellerBO, EnumOrderStatus status, boolean active,
            CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.storeBO = storeBO;
        this.clientBO = clientBO;
        this.sellerBO = sellerBO;
        this.status = status;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAtVO createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

    public StoreBO getstoreBO() {
        return storeBO;
    }

    public void setstoreBO(StoreBO storeBO) {
        this.storeBO = storeBO;
    }

    public ClientBO getclientBO() {
        return clientBO;
    }

    public void setclientBO(ClientBO clientBO) {
        this.clientBO = clientBO;
    }

    public SellerBO getsellerBO() {
        return sellerBO;
    }

    public void setsellerBO(SellerBO sellerBO) {
        this.sellerBO = sellerBO;
    }

    public StoreBO getStoreBO() {
        return storeBO;
    }

    public void setStoreBO(StoreBO storeBO) {
        this.storeBO = storeBO;
    }

    public ClientBO getClientBO() {
        return clientBO;
    }

    public void setClientBO(ClientBO clientBO) {
        this.clientBO = clientBO;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EnumOrderStatus status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isactive() {
        return active;
    }

    public void setactive(boolean active) {
        this.active = active;
    }

}
