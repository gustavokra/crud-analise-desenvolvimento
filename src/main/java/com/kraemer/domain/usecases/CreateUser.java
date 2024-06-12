package com.kraemer.domain.usecases;

import java.util.List;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.exception.CrudException;
public class CreateUser {
    
    private IUserRepository userRepository;

    public CreateUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UserDTO dto) {
        verifyExistingUser(dto.getDocument());
        verifyExistingUsername(dto.getUsername());

        var userBO = UserMapper.toBO(dto);
        userBO = userRepository.create(userBO);

        return UserMapper.toDTO(userBO);
    }

    private void verifyExistingUser(String document) {
        var queryFieldDoc = new QueryFieldInfoVO("document", document);
        var queryFieldDisabled = new QueryFieldInfoVO("disabledAt", null);

        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldDoc, queryFieldDisabled));

        if (existingUserBO != null) {
            throw new CrudException(EnumErrorCode.USUARIO_CADASTRADO);
        }
    }

    private void verifyExistingUsername(String username) {
        var queryFieldUserName = new QueryFieldInfoVO("username", username);

        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldUserName));

        if (existingUserBO != null) {
            throw new CrudException(EnumErrorCode.USERNAME_CADASTRADO);
        }
    }

}
