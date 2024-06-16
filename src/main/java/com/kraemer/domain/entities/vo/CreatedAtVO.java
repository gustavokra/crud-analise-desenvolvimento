package com.kraemer.domain.entities.vo;

import java.time.LocalDateTime;

public class CreatedAtVO {
    
    final LocalDateTime createdAt;

    public CreatedAtVO(final LocalDateTime createdAtVO) {
        this.createdAt = createdAtVO != null ? createdAtVO : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdAt;
    }

}
