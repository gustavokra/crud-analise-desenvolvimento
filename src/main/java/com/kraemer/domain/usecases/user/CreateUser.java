package com.kraemer.domain.usecases.user;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.exception.CrudException;
public class CreateUser {
    
    private UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UserDTO dto) {
        verifyExistingUser(dto.getDocument());
        verifyExistingUsername(dto.getUsername());

        var userBO = UserMapper.mapDTOToBO(dto);
        userBO = userRepository.create(userBO);

        return UserMapper.mapBOtoDTO(userBO);
    }

    private void verifyExistingUser(String document) {
        var queryFieldDoc = new QueryFieldVO("document", document);
        var queryFieldDisabled = new QueryFieldVO("disabledAt", null);

        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldDoc, queryFieldDisabled));

        if (existingUserBO != null) {
            throw new CrudException(EnumCrudError.ITEM_CADASTRADO);
        }
    }

    private void verifyExistingUsername(String username) {
        var queryFieldUserName = new QueryFieldVO("username", username);

        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldUserName));

        if (existingUserBO != null) {
            throw new CrudException(EnumCrudError.USERNAME_JA_CADASTRADO);
        }
    }

}
