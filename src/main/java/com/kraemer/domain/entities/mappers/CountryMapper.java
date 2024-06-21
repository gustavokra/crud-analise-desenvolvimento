package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.CountryBO;
import com.kraemer.domain.entities.dto.CountryDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class CountryMapper {

    public static CountryBO toBO(CountryDTO dto) {
        return new CountryBO(
                dto.getId(),
                dto.getDescription(),
                dto.getAcronym(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static CountryDTO toDTO(CountryBO bo) {
        CountryDTO dto = new CountryDTO();
        dto.setId(bo.getId());
        dto.setDescription(bo.getDescription());
        dto.setAcronym(bo.getAcronym());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
