package com.kraemer.domain.usecases.user;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.ICrudRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateUserInfo {
    private ICrudRepository<UserBO> crudRepository;

    public UpdateUserInfo(ICrudRepository<UserBO> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public UserDTO execute(UserDTO dto, Long userId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", userId);

        var existingUserBO = crudRepository.findFirstBy(List.of(queryFieldDoc));

        if (existingUserBO == null) {
            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingUserBO.handleUpdateInfo(UserMapper.toBO(dto));

        crudRepository.merge(existingUserBO);

        return UserMapper.toDTO(existingUserBO);

    }
}
