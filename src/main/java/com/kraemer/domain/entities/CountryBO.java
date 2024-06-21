package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.StringUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class CountryBO {

    public Long id;

    private String description;

    private String acronym;

    public CreatedAtVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public CountryBO(Long id, String description, String acronym, CreatedAtVO createdAt, LocalDateTime updatedAt,
            LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.acronym = acronym;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public void handleUpdateInfo(CountryBO bo) {
        if (StringUtil.isNotNullOrEmpty(bo.getDescription())) {
            this.description = bo.getDescription();
        }

        if (StringUtil.isNotNullOrEmpty(bo.getAcronym())) {
            this.acronym = bo.getAcronym();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void handleDisable() {
        if (this.disabledAt != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO);
        }

        this.disabledAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public String getAcronym() {
        return acronym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAtVO createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

}
