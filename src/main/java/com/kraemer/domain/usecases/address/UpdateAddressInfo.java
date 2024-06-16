package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateAddressInfo {

    private AddressRepository addressRepository;

    public UpdateAddressInfo(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO addressDTO, Long idAddressToUpdate) {
        var queryFieldId = new QueryFieldInfoVO("id", idAddressToUpdate);

        var addressToUpdate = addressRepository.returnFirstBy(List.of(queryFieldId));

        if (addressToUpdate == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        addressToUpdate.handleUpdateInfo(AddressMapper.mapAddressDTOToBO(addressDTO));

        addressRepository.merge(addressToUpdate);

        return AddressMapper.mapAddressBOToDTO(addressToUpdate);
    }

}
