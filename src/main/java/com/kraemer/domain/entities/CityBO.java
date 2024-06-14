package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.StringUtil;

public class CityBO extends CrudBO {

    private String description;

    public CityBO(Long id, String description, CreatedAtVO createdAt, LocalDateTime updatedAt,
            LocalDateTime disabledAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public void handleUpdateInfo(CityBO bo) {
        if (StringUtil.isNotNullOrEmpty(bo.getDescription())) {
            this.description = bo.getDescription();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

}
