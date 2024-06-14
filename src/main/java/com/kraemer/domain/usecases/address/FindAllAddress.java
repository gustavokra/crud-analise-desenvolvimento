package com.kraemer.domain.usecases.address;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindAllAddress {

    private IAddressRepository addressRepository;

    public FindAllAddress(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> execute(boolean throwsException) {
        try {
            List<AddressBO> addressBO = addressRepository.findAll();

            return ListUtil.stream(addressBO)
                    .map(AddressMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (CrudException ce) {
            throw new CrudException(EnumErrorCode.ERRO_LISTAR_USUARIOS);
        }
    }
}
