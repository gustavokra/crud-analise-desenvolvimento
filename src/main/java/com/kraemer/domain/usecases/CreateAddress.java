package com.kraemer.domain.usecases;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.UserMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class CreateAddress {

    private IUserRepository userRepository;

    public CreateAddress(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
