package org.acme.domain.usecases;

import java.util.List;

import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.entities.mappers.UserMapper;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.repositories.IUserRepository;
import org.acme.domain.utils.exception.CrudException;

public class DisableUser {
    
    private IUserRepository userRepository;

    public DisableUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(Long userId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", userId);
        var existingUserBO = userRepository.findFirstBy(List.of(queryFieldDoc));

        if (existingUserBO == null) {
            throw new CrudException(EnumErrorCode.USUARIO_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingUserBO.handleDisable();

        userRepository.merge(existingUserBO);

        return UserMapper.toDTO(existingUserBO);

    }

}
