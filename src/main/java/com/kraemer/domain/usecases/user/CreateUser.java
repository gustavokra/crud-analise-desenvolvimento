package com.kraemer.domain.usecases.user;

import java.util.List;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.ICrudRepository;
import com.kraemer.domain.utils.exception.CrudException;
public class CreateUser {
    
    private ICrudRepository<UserBO> crudRepository;

    public CreateUser(ICrudRepository<UserBO> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public UserDTO execute(UserDTO dto) {
        verifyExistingUser(dto.getDocument());
        verifyExistingUsername(dto.getUsername());

        var userBO = UserMapper.toBO(dto);
        userBO = crudRepository.create(userBO);

        return UserMapper.toDTO(userBO);
    }

    private void verifyExistingUser(String document) {
        var queryFieldDoc = new QueryFieldInfoVO("document", document);
        var queryFieldDisabled = new QueryFieldInfoVO("disabledAt", null);

        var existingUserBO = crudRepository.findFirstBy(List.of(queryFieldDoc, queryFieldDisabled));

        if (existingUserBO != null) {
            throw new CrudException(EnumErrorCode.ITEM_CADASTRADO);
        }
    }

    private void verifyExistingUsername(String username) {
        var queryFieldUserName = new QueryFieldInfoVO("username", username);

        var existingUserBO = crudRepository.findFirstBy(List.of(queryFieldUserName));

        if (existingUserBO != null) {
            throw new CrudException(EnumErrorCode.USERNAME_CADASTRADO);
        }
    }

}
