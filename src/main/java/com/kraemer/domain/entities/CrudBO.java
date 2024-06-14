package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;

public abstract class CrudBO {

    public Long id;

    public CreatedAtVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public Long getId() {
        return id;
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

    public void handleDisable() {
        this.disabledAt = LocalDateTime.now();
    }

}
