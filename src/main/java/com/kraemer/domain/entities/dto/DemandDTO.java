package com.kraemer.domain.entities.dto;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.enums.EnumOrderStatus;

public class DemandDTO extends CrudDTO {



    private UserDTO userDTO;

    private ClientDTO clientDTO;

    private SellerDTO sellerDTO;

    private EnumOrderStatus status;

    private boolean active;

    

   

   

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public SellerDTO getSellerDTO() {
        return sellerDTO;
    }

    public void setSellerDTO(SellerDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EnumOrderStatus status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }







    

    






}
