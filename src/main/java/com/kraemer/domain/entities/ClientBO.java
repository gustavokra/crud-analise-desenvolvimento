package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreationDateVO;

public class ClientBO extends CrudBO {

    private String name;

    private AddressBO addressBO;

    private boolean active;

    public ClientBO(Long id, String name, AddressBO addressBO, boolean active, CreationDateVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.name = name;
        this.addressBO = addressBO;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public String getName() {
        return name;
    }

    public AddressBO getAddressBO() {
        return addressBO;
    }

    public boolean isActive() {
        return active;
    }

}
