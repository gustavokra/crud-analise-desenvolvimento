package com.kraemer.domain.entities.vo;

import java.time.LocalDateTime;

public class CreatedAtVO {
    
    final LocalDateTime creationDate;

    public CreatedAtVO(final LocalDateTime creationDate) {
        this.creationDate = creationDate != null ? creationDate : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return creationDate;
    }

}
