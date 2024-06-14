package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.CityBO;
import com.kraemer.domain.entities.dto.CityDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class CityMapper {

    public static CityBO toBO(CityDTO dto) {
        return new CityBO(
                dto.getId(),
                dto.getDescription(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static CityDTO toDTO(CityBO bo) {
        CityDTO dto = new CityDTO();
        dto.setId(bo.getId());
        dto.setDescription(bo.getDescription());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
