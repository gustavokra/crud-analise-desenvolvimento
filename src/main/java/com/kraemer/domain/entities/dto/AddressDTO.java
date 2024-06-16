package com.kraemer.domain.entities.dto;

public class AddressDTO extends CrudDTO {

    private CountryDTO country;

    private StateDTO state;

    private CityDTO city;

    private String neigborhood;

    private String street;

    private String number;


    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
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
