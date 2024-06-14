package com.kraemer.domain.entities.dto;

import java.time.LocalDateTime;

public class SellerDTO extends CrudDTO{



    private String name;

    private AddressDTO addressDTO;

    private boolean active;

    

   

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }







    

    






}
