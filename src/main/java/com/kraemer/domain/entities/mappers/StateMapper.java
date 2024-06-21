package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.dto.StateDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class StateMapper {
    public static StateBO toBO(StateDTO dto) {
        return new StateBO(
            dto.getId(),
            dto.getDescription(),
            dto.getAcronym(),
            new CreatedAtVO(dto.getCreatedAt()), 
            dto.getUpdatedAt(),
            dto.getDisabledAt()
        );
    }

    public static StateDTO toDTO(StateBO bo) {
        StateDTO dto = new StateDTO();
        dto.setId(bo.getId());
        dto.setDescription(bo.getDescription());
        dto.setAcronym(bo.getAcronym());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }
}
