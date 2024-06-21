package com.kraemer.domain.usecases.address;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class ReturnAllAddress {

    private AddressRepository addressRepository;

    public ReturnAllAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> execute(boolean throwsException) {
        try {
            List<AddressBO> addressBO = addressRepository.returnAll();

            return ListUtil.stream(addressBO)
                    .map(AddressMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (CrudException ce) {
            throw new CrudException(EnumCrudError.ERRO_LISTAR);
        }
    }
}
