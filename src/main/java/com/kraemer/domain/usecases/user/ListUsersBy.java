package com.kraemer.domain.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class ListUsersBy {

    private UserRepository userRepository;

    public ListUsersBy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(List<QueryFieldVO> queryFields, boolean throwsException) {
        var usersBO = userRepository.listAllBy(queryFields);

        if (ListUtil.isNullOrEmpty(usersBO) && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return ListUtil.stream(usersBO)
                .map(UserMapper::mapBOtoDTO)
                .collect(Collectors.toList());
    }

}
