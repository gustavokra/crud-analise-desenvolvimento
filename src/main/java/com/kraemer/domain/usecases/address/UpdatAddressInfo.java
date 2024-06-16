package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdatAddressInfo {
    
    private AddressRepository addressRepository;

    public UpdatAddressInfo(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto, Long userId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", userId);

        var existingAddressBO = addressRepository.returnFirstBy(List.of(queryFieldDoc));

        if (existingAddressBO == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingAddressBO.handleUpdateInfo(AddressMapper.mapAddressDTOToBO(dto));

        addressRepository.merge(existingAddressBO);

        return AddressMapper.mapAddressBOToDTO(existingAddressBO);

    }

}
