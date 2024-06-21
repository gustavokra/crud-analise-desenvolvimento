package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.CityBO;
import com.kraemer.domain.entities.dto.CityDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class CityMapper {

    public static CityBO toBO(CityDTO cityDTO) {
        return new CityBO(
                cityDTO.getId(),
                cityDTO.getDescription(),
                new CreatedAtVO(cityDTO.getCreatedAt()),
                cityDTO.getUpdatedAt(),
                cityDTO.getDisabledAt());
    }

    public static CityDTO toDTO(CityBO cityBO) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(cityBO.getId());
        cityDTO.setDescription(cityBO.getDescription());
        cityDTO.setCreatedAt(cityBO.getCreatedAt().getValue());
        cityDTO.setUpdatedAt(cityBO.getUpdatedAt());
        cityDTO.setDisabledAt(cityBO.getDisabledAt());
        return cityDTO;
    }

}
