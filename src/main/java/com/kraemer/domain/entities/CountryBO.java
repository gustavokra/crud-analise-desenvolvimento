package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;

public class CountryBO extends CrudBO {

    private String description;

    private String acronym;

    public CountryBO(Long id, String description, String acronym, CreatedAtVO createdAt, LocalDateTime updatedAt,
            LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.acronym = acronym;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public String getDescription() {
        return description;
    }

    public String getAcronym() {
        return acronym;
    }

}
