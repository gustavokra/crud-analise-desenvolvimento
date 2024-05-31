package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class AddressBO implements ICrudBO {

    private Long id;

    private CountryBO countryBO;

    private StateBO stateBO;

    private CityBO cityBO;

    private String street;

    private String number;

    private boolean active;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

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

    public Long getId() {
        return id;
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

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

}
