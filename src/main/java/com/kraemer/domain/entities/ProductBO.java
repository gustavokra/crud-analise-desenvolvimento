package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreationDateVO;

public class ProductBO extends CrudBO {

    private StockBO stockBO;

    private String description;

    private boolean active;

    public ProductBO(Long id, StockBO stockBO, String description, boolean active, CreationDateVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.stockBO = stockBO;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public StockBO getStockBO() {
        return stockBO;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

}
