package org.acme.domain.repositories;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;

public interface ICrudBO {
    
    public Long getId();

    public CreatedAtVO getCreatedAt();

    public LocalDateTime getUpdatedAt();

    public LocalDateTime getDisabledAt();

}
