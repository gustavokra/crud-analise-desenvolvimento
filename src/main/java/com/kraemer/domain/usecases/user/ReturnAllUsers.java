package com.kraemer.domain.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.UserBO;
import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class ReturnAllUsers {

    private UserRepository userRepository;

    public ReturnAllUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(boolean throwsException) {
        try {
            List<UserBO> usersBO = userRepository.returnAll();
            
            return ListUtil.stream(usersBO)
                    .map(UserMapper::mapBOtoDTO)
                    .collect(Collectors.toList());
        } catch (CrudException ce) {
            throw new CrudException(EnumCrudError.ERRO_LISTAR_USUARIOS);
        }

    }
}
