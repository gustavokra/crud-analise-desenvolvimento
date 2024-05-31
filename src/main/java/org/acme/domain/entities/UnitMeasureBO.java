package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class UnitMeasureBO implements ICrudBO {

    private Long id;

    private String acronym;

    private String description;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public UnitMeasureBO(Long id, String acronym, String description, boolean active, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.acronym = acronym;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public Long getId() {
        return id;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getDescription() {
        return description;
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
