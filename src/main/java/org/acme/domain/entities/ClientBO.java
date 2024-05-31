package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class ClientBO implements ICrudBO {

    private Long id;

    private String name;

    private AddressBO addressBO;

    private UserBO userBO;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public ClientBO(Long id, String name, AddressBO addressBO, UserBO userBO, boolean active, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.name = name;
        this.addressBO = addressBO;
        this.userBO = userBO;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
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

    public UserBO getUserBO() {
        return userBO;
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
