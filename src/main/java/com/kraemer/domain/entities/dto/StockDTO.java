package com.kraemer.domain.entities.dto;

public class StockDTO extends CrudDTO {

    private String description;

    private boolean active;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
