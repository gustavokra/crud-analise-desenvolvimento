package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.CityBO;
import com.kraemer.domain.entities.CountryBO;
import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.vo.CreationDateVO;

public class AddressMapper {

    public static AddressBO toBO(AddressDTO addressDTO) {
        CountryBO countryBO = null;
        StateBO stateBO = null;
        CityBO cityBO = null;

        if (addressDTO.getCountry() != null) {
            countryBO = CountryMapper.toBO(addressDTO.getCountry());
        }

        if (addressDTO.getState() != null) {
            stateBO = StateMapper.toBO(addressDTO.getState());
        }

        if (addressDTO.getCity() != null) {
            cityBO = CityMapper.toBO(addressDTO.getCity());
        }

        return new AddressBO(
                addressDTO.getId(),
                countryBO,
                stateBO,
                cityBO,
                addressDTO.getNeigborhood(),
                addressDTO.getStreet(),
                addressDTO.getNumber(),
                new CreationDateVO(addressDTO.getCreatedAt()),
                addressDTO.getUpdatedAt(),
                addressDTO.getDisabledAt());
    }

    public static AddressDTO toDTO(AddressBO addressBO) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressBO.getId());
        if (addressBO.getCountryBO() != null) {
            addressDTO.setCountry(CountryMapper.toDTO(addressBO.getCountryBO()));
        }
        if (addressBO.getStateBO() != null) {
            addressDTO.setState(StateMapper.toDTO(addressBO.getStateBO()));
        }
        if (addressBO.getCityBO() != null) {
            addressDTO.setCity(CityMapper.toDTO(addressBO.getCityBO()));
        }
        addressDTO.setNeigborhood(addressBO.getNeighborhood());
        addressDTO.setStreet(addressBO.getStreet());
        addressDTO.setNumber(addressBO.getNumber());
        addressDTO.setCreatedAt(addressBO.getCreatedAt().getValue());
        addressDTO.setUpdatedAt(addressBO.getUpdatedAt());
        addressDTO.setDisabledAt(addressBO.getDisabledAt());
        return addressDTO;
    }

}
