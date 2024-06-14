package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdatAddressInfo {
    
    private IAddressRepository addressRepository;

    public UpdatAddressInfo(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto, Long userId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", userId);

        var existingAddressBO = addressRepository.findFirstBy(List.of(queryFieldDoc));

        if (existingAddressBO == null) {
            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingAddressBO.handleUpdateInfo(AddressMapper.toBO(dto));

        addressRepository.merge(existingAddressBO);

        return AddressMapper.toDTO(existingAddressBO);

    }

}
