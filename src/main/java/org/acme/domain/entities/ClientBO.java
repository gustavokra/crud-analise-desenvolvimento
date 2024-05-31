package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;

public class ClientBO {

    private String name;

    private AddressBO addressBO;

    private StoreBO storeBO;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public ClientBO(String name, AddressBO addressBO, StoreBO storeBO, boolean active, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.name = name;
        this.addressBO = addressBO;
        this.storeBO = storeBO;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBO getAddressBO() {
        return addressBO;
    }

    public void setAddressBO(AddressBO addressBO) {
        this.addressBO = addressBO;
    }

    public StoreBO getStoreBO() {
        return storeBO;
    }

    public void setStoreBO(StoreBO storeBO) {
        this.storeBO = storeBO;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    

}
