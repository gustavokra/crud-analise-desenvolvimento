package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateAddress {

    private AddressRepository addressRepository;

    public UpdateAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO addressDTO, Long idAddressToUpdate) {
        var queryFieldId = new QueryFieldVO("id", idAddressToUpdate);

        var addressToUpdate = addressRepository.findFirstBy(List.of(queryFieldId));

        if (addressToUpdate == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        if (addressToUpdate.getDisabledAt() != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO, "identificador");
        }

        addressToUpdate.handleUpdateInfo(AddressMapper.toBO(addressDTO));

        addressRepository.merge(addressToUpdate);

        return AddressMapper.toDTO(addressToUpdate);
    }

}
