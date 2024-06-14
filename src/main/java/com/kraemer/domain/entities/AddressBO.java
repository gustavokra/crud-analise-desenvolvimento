package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;

public class AddressBO extends CrudBO {

    private CountryBO countryBO;

    private StateBO stateBO;

    private CityBO cityBO;

    private String street;

    private String number;

    private boolean active;

    public AddressBO(Long id, CountryBO countryBO, StateBO stateBO, CityBO cityBO, String street, String number,
            boolean active, CreatedAtVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.countryBO = countryBO;
        this.stateBO = stateBO;
        this.cityBO = cityBO;
        this.street = street;
        this.number = number;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
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

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public boolean isActive() {
        return active;
    }

}
