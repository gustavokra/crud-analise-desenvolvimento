package com.kraemer.domain.entities.vo;

import java.time.LocalDateTime;

public class CreationDateVO {
    
    final LocalDateTime creationDate;

    public CreationDateVO(final LocalDateTime creationDate) {
        this.creationDate = creationDate != null ? creationDate : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return creationDate;
    }

}
