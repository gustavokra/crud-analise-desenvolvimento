package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;

public class AddressBO {
    
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

    public void setId(Long id) {
        this.id = id;
    }

    public CountryBO getCountryBO() {
        return countryBO;
    }

    public void setCountryBO(CountryBO countryBO) {
        this.countryBO = countryBO;
    }

    public StateBO getStateBO() {
        return stateBO;
    }

    public void setStateBO(StateBO stateBO) {
        this.stateBO = stateBO;
    }

    public CityBO getCityBO() {
        return cityBO;
    }

    public void setCityBO(CityBO cityBO) {
        this.cityBO = cityBO;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAtVO createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

    
    
}
