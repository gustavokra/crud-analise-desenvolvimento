package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class StockBO implements ICrudBO {

    private Long id;

    private String description;

    private UserBO userBO;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public StockBO(Long id, String description, UserBO userBO, boolean active, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.userBO = userBO;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
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
