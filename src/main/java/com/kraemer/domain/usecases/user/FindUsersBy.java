package com.kraemer.domain.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindUsersBy {

    private UserRepository userRepository;

    public FindUsersBy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(List<QueryFieldInfoVO> queryFields, boolean throwsException) {
        var usersBO = userRepository.findAllBy(queryFields);

        if (ListUtil.isNullOrEmpty(usersBO) && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldInfoVO::getFieldName)
                    .collect(Collectors.joining(", "));

            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return ListUtil.stream(usersBO)
                .map(UserMapper::mapUserBOtoDTO)
                .collect(Collectors.toList());
    }

}
