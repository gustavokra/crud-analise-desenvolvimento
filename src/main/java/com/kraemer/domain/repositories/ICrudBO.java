package com.kraemer.domain.repositories;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;

public interface ICrudBO {
    
    public Long getId();

    public CreatedAtVO getCreatedAt();

    public LocalDateTime getUpdatedAt();

    public LocalDateTime getDisabledAt();

}
