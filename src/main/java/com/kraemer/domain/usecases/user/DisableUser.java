package com.kraemer.domain.usecases.user;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class DisableUser {
    
    private IUserRepository userRepository;

    public DisableUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(Long userId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", userId);
        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldDoc));

        if (existingUserBO == null) {
            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingUserBO.handleDisable();

        userRepository.merge(existingUserBO);

        return UserMapper.toDTO(existingUserBO);

    }

}
