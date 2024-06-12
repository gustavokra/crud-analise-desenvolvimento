package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.repositories.ICrudBO;

public class CountryBO implements ICrudBO {

    private Long id;

    private String description;

    private String acronym;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public CountryBO(Long id, String description, String acronym, CreatedAtVO createdAt, LocalDateTime updatedAt,
            LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.acronym = acronym;
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

    public String getAcronym() {
        return acronym;
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
