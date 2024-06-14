package com.kraemer.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;

import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.utils.StringUtil;

public class AddressBO extends CrudBO {

    private CountryBO countryBO;

    private StateBO stateBO;

    private CityBO cityBO;

    private String neighborhood;

    private String street;

    private String number;

    public AddressBO(Long id, CountryBO countryBO, StateBO stateBO, CityBO cityBO, String street, String number,
            CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.countryBO = countryBO;
        this.stateBO = stateBO;
        this.cityBO = cityBO;
        this.street = street;
        this.number = number;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public void handleUpdateInfo(AddressBO bo) {

        Optional.ofNullable(bo.getCountryBO()).ifPresent(this.countryBO::handleUpdateInfo);
        Optional.ofNullable(bo.getStateBO()).ifPresent(this.stateBO::handleUpdateInfo);
        Optional.ofNullable(bo.getCityBO()).ifPresent(this.cityBO::handleUpdateInfo);

        if (StringUtil.isNotNullOrEmpty(bo.getNumber())) {
            this.number = bo.getNumber();
        }

        if (StringUtil.isNotNullOrEmpty(bo.getStreet())) {
            this.street = bo.getStreet();
        }

        if (StringUtil.isNotNullOrEmpty(bo.getNeighborhood())) {
            this.neighborhood = bo.getNeighborhood();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public CountryBO getCountryBO() {
        return countryBO;
    }

    public StateBO getStateBO() {
        return stateBO;
    }

    public CityBO getCityBO() {
        return cityBO;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

}
