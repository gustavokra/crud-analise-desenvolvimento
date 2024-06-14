package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.StringUtil;

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

    public void handleUpdateInfo(CountryBO bo) {
        if (StringUtil.isNotNullOrEmpty(bo.getDescription())) {
            this.description = bo.getDescription();
        }

        if (StringUtil.isNotNullOrEmpty(bo.getAcronym())) {
            this.acronym = bo.getAcronym();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public String getAcronym() {
        return acronym;
    }

}
