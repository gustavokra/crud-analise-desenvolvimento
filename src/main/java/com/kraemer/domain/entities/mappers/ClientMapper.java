package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.ClientBO;
import com.kraemer.domain.entities.dto.ClientDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class ClientMapper {

    public static ClientBO toBO(ClientDTO dto) {
        return new ClientBO(dto.getId(),
                dto.getName(),
                AddressMapper.toBO(dto.getAddressDTO()),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());
    }

    public static ClientDTO toDTO(ClientBO bo) {
        ClientDTO dto = new ClientDTO();
        dto.setId(bo.getId());
        dto.setName(bo.getName());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setDisabledAt(bo.getDisabledAt());
        return dto;
    }

}
