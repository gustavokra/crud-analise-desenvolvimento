package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.CityBO;
import com.kraemer.domain.entities.CountryBO;
import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class AddressMapper {

    public static AddressBO toBO(AddressDTO dto) {
        CountryBO countryBO = null;
        StateBO stateBO = null;
        CityBO cityBO = null;

        if (dto.getCountryDTO() != null) {
            countryBO = CountryMapper.toBO(dto.getCountryDTO());
        }

        if (dto.getStateDTO() != null) {
            stateBO = StateMapper.toBO(dto.getStateDTO());
        }

        if (dto.getCityDTO() != null) {
            cityBO = CityMapper.toBO(dto.getCityDTO());
        }

        return new AddressBO(
                dto.getId(),
                countryBO,
                stateBO,
                cityBO,
                dto.getStreet(),
                dto.getNumber(),
                dto.isActive(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static AddressDTO toDTO(AddressBO bo) {
        AddressDTO dto = new AddressDTO();
        dto.setId(bo.getId());
        if (bo.getCountryBO() != null) {
            dto.setCountryDTO(CountryMapper.toDTO(bo.getCountryBO()));
        }
        if (bo.getStateBO() != null) {
            dto.setStateDTO(StateMapper.toDTO(bo.getStateBO()));
        }
        if (bo.getCityBO() != null) {
            dto.setCityDTO(CityMapper.toDTO(bo.getCityBO()));
        }
        dto.setStreet(bo.getStreet());
        dto.setNumber(bo.getNumber());
        dto.setActive(bo.isActive());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
