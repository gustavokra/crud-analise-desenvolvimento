package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.vo.CreationDateVO;

public class UserMapper {

    public static UserDTO mapBOtoDTO(UserBO userBO) {
        var userDTO = new UserDTO();
        userDTO.setId(userBO.getId());
        userDTO.setDocument(userBO.getDocument());
        userDTO.setName(userBO.getName());
        userDTO.setUsername(userBO.getUsername());
        userDTO.setPassword(userBO.getPassword());
        userDTO.setCreatedAt(userBO.getCreatedAt() != null ? userBO.getCreatedAt().getValue() : null);
        userDTO.setDisabledAt(userBO.getDisabledAt());
        userDTO.setUpdatedAt(userBO.getUpdatedAt());

        return userDTO;
    }

    public static UserBO mapDTOToBO(UserDTO userDTO) {
        var userBO = new UserBO(userDTO.getId(),
                userDTO.getDocument(),
                userDTO.getName(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                new CreationDateVO(userDTO.getCreatedAt()),
                userDTO.getUpdatedAt(),
                userDTO.getDisabledAt());

        return userBO;
    }

}
