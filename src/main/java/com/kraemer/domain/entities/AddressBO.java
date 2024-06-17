package com.kraemer.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;

import com.kraemer.domain.entities.vo.CreationDateVO;
import com.kraemer.domain.utils.StringUtil;

public class AddressBO {

    public Long id;

    private CountryBO countryBO;

    private StateBO stateBO;

    private CityBO cityBO;

    private String neighborhood;

    private String street;

    private String number;

    public CreationDateVO createdAt;

    public LocalDateTime updatedAt;

    public LocalDateTime disabledAt;

    public AddressBO(Long id, CountryBO countryBO, StateBO stateBO, CityBO cityBO, String neighborhood, 
        String street, String number, CreationDateVO createdAt, LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.countryBO = countryBO;
        this.stateBO = stateBO;
        this.cityBO = cityBO;
        this.neighborhood = neighborhood;
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

    public void handleDisable() {
        this.disabledAt = LocalDateTime.now();
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

    public Long getId() {
        return id;
    }

    public CreationDateVO getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

}
