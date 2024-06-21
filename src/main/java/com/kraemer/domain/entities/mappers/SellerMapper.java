package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.SellerBO;
import com.kraemer.domain.entities.dto.SellerDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class SellerMapper {

    public static SellerBO toBO(SellerDTO dto) {
        return new SellerBO(dto.getId(), 
        dto.getName(), 
        AddressMapper.toBO(dto.getAddressDTO()), 
        new CreatedAtVO(dto.getCreatedAt()), 
        dto.getUpdatedAt(), 
        dto.getUpdatedAt());
    }

    public static SellerDTO toDTO(SellerBO bo) {
        var dto = new SellerDTO();
        dto.setId(bo.getId());
        dto.setName(bo.getName());
        dto.setAddressDTO(AddressMapper.toDTO(bo.getAddressBO()));
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
