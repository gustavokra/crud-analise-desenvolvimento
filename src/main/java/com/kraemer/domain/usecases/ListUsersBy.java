package com.kraemer.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

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
