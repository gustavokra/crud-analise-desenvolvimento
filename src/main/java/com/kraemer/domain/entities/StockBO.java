package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreationDateVO;

public class StockBO extends CrudBO {



    private String description;

    private boolean active;

    public StockBO(Long id, String description, boolean active, CreationDateVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

}
