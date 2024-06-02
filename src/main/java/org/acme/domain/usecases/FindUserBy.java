package org.acme.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.domain.entities.dto.UserDTO;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.entities.mappers.UserMapper;
import org.acme.domain.entities.vo.QueryFieldInfoVO;
import org.acme.domain.repositories.IUserRepository;
import org.acme.domain.utils.ListUtil;
import org.acme.domain.utils.exception.CrudException;

public class FindUserBy {
    
    IUserRepository userRepository;

    public FindUserBy(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(List<QueryFieldInfoVO> queryFields, boolean throwsException) {
        var userBO = userRepository.findFirstBy(queryFields);

        if (userBO == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldInfoVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumErrorCode.USUARIO_NAO_ENCONTRADO_FILTROS, fields);
        }

        return userBO != null ? UserMapper.toDTO(userBO) : null;
    }


}
