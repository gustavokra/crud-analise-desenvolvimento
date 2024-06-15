package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.ICrudRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class DisableAddress {
    
    private ICrudRepository<AddressBO> addressRepository;

    public DisableAddress(ICrudRepository<AddressBO> addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(Long addressId) {

        var queryFieldDoc = new QueryFieldInfoVO("id", addressId);
        var existingAddressBO = addressRepository.findFirstBy(List.of(queryFieldDoc));

        if (existingAddressBO == null) {
            throw new CrudException(EnumErrorCode.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        existingAddressBO.handleDisable();

        addressRepository.merge(existingAddressBO);

        return AddressMapper.toDTO(existingAddressBO);

    }

}
