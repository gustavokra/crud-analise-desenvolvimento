package org.acme.domain.entities.mappers;

import org.acme.domain.entities.UserBO;
import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.vo.CreatedAtVO;

public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {
        var dto = new UserDTO();
        dto.setId(bo.getId());
        dto.setDocument(bo.getDocument());
        dto.setName(bo.getName());
        dto.setUsername(bo.getUsername());
        dto.setPassword(bo.getPassword());
        dto.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt().getValue() : null);
        dto.setDisabledAt(bo.getDisabledAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static UserBO toBO(UserDTO dto) {
        var bo = new UserBO(dto.getId(),
                dto.getDocument(),
                dto.getName(),
                dto.getUsername(),
                dto.getPassword(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getUpdatedAt(),
                dto.getDisabledAt());

        return bo;
    }

}
