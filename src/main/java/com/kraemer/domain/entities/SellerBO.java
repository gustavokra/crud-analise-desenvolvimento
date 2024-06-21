package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.exception.CrudException;

public class SellerBO {

    public Long id;

    private String name;

    private AddressBO addressBO;

    public CreatedAtVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public SellerBO(Long id, String name, AddressBO addressBO, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.name = name;
        this.addressBO = addressBO;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public void handleDisable() {
        if (this.disabledAt != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO);
        }

        this.disabledAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AddressBO getAddressBO() {
        return addressBO;
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
