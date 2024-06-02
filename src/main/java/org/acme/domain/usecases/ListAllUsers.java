package org.acme.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.domain.entities.UserBO;
import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.entities.mappers.UserMapper;
import org.acme.domain.repositories.IUserRepository;
import org.acme.domain.utils.ListUtil;
import org.acme.domain.utils.exception.CrudException;

public class ListAllUsers {

    private IUserRepository userRepository;

    public ListAllUsers(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(boolean throwsException) {
        try {
            List<UserBO> usersBO = userRepository.findAll();
            
            return ListUtil.stream(usersBO)
                    .map(UserMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (CrudException ce) {
            throw new CrudException(EnumErrorCode.ERRO_LISTAR_USUARIOS);
        }

    }
}
