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

        if (dto.getCountry() != null) {
            countryBO = CountryMapper.toBO(dto.getCountry());
        }

        if (dto.getState() != null) {
            stateBO = StateMapper.toBO(dto.getState());
        }

        if (dto.getCity() != null) {
            cityBO = CityMapper.toBO(dto.getCity());
        }

        return new AddressBO(
                dto.getId(),
                countryBO,
                stateBO,
                cityBO,
                dto.getNeigborhood(),
                dto.getStreet(),
                dto.getNumber(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static AddressDTO toDTO(AddressBO bo) {
        AddressDTO dto = new AddressDTO();
        dto.setId(bo.getId());
        if (bo.getCountryBO() != null) {
            dto.setCountry(CountryMapper.toDTO(bo.getCountryBO()));
        }
        if (bo.getStateBO() != null) {
            dto.setState(StateMapper.toDTO(bo.getStateBO()));
        }
        if (bo.getCityBO() != null) {
            dto.setCity(CityMapper.toDTO(bo.getCityBO()));
        }
        dto.setNeigborhood(bo.getNeighborhood());
        dto.setStreet(bo.getStreet());
        dto.setNumber(bo.getNumber());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
