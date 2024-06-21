package com.kraemer.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.runtime.util.StringUtil;

public class ClientBO {

    public Long id;

    private String name;

    private AddressBO addressBO;

    public CreatedAtVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public ClientBO(Long id, String name, AddressBO addressBO, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.name = name;
        this.addressBO = addressBO;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public void handleUpdate(ClientBO bo) {

        if(this.disabledAt != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO);
        }
        
        if(StringUtil.isNullOrEmpty(bo.getName())) {
            this.name = bo.getName();
        }

        Optional.ofNullable(bo.getAddressBO()).ifPresent(this.addressBO::handleUpdateInfo);

        this.updatedAt = LocalDateTime.now();
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
