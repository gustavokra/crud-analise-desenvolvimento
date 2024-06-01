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

public class ListUsersBy {

    private IUserRepository userRepository;

    public ListUsersBy(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(List<QueryFieldInfoVO> queryFields, boolean throwsException) {
        var usersBO = userRepository.findAllBy(queryFields);

        if (ListUtil.isNullOrEmpty(usersBO) && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldInfoVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumErrorCode.USUARIO_NAO_ENCONTRADO_FILTROS, fields);
        }

        return ListUtil.stream(usersBO)
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

}
