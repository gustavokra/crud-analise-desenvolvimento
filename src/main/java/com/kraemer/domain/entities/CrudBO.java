package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreationDateVO;

public abstract class CrudBO {

    public Long id;

    public CreationDateVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public Long getId() {
        return id;
    }

    public CreationDateVO getCreatedAt() {
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
