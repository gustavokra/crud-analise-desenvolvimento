package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.StockBO;
import com.kraemer.domain.entities.dto.StockDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class StockMapper {
    
    public static StockBO toBO(StockDTO dto) {
        return new StockBO(
            dto.getId(), 
            dto.getDescription(), 
            new CreatedAtVO(dto.getCreatedAt()), 
            dto.getUpdatedAt(), 
            dto.getDisabledAt());
    }

    public static StockDTO toDTO(StockBO bo) {
        StockDTO dto = new StockDTO();
        dto.setId(bo.getId());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());

        return dto;
    }
}
