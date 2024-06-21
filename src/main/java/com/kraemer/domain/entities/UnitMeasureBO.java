package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.exception.CrudException;

public class UnitMeasureBO {

    public Long id;

    private String acronym;

    private String description;

    public CreatedAtVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public UnitMeasureBO(Long id, String acronym, String description, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.acronym = acronym;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
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

    public String getAcronym() {
        return acronym;
    }

    public String getDescription() {
        return description;
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
