package com.kraemer.domain.entities.dto;

public class AddressDTO extends CrudDTO {

    private CountryDTO countryDTO;

    private StateDTO stateDTO;

    private CityDTO cityDTO;

    private String neigborhood;

    private String street;

    private String number;

    public CountryDTO getCountryDTO() {
        return countryDTO;
    }

    public void setCountryDTO(CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }

    public StateDTO getStateDTO() {
        return stateDTO;
    }

    public void setStateDTO(StateDTO stateDTO) {
        this.stateDTO = stateDTO;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
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

    public String getNeigborhood() {
        return neigborhood;
    }

    public void setNeigborhood(String neigborhood) {
        this.neigborhood = neigborhood;
    }
}