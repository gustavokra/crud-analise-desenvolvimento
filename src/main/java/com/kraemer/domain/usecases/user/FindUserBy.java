package com.kraemer.domain.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

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

            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return userBO != null ? UserMapper.toDTO(userBO) : null;
    }

}
