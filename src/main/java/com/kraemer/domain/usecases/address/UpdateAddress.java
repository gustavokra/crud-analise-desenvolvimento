package com.kraemer.domain.usecases.address;

import java.util.List;

import com.kraemer.domain.entities.AddressBO;
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
        AddressBO updatedAddress = merge(addressDTO, idAddressToUpdate);
        return AddressMapper.toDTO(updatedAddress);
    }

    private AddressBO merge(AddressDTO addressDTO, Long idAddressToUpdate) {
        AddressBO addressToUpdate = findAddress(idAddressToUpdate);
        addressToUpdate.handleUpdateInfo(AddressMapper.toBO(addressDTO));
        return addressRepository.merge(addressToUpdate);
    }

    private AddressBO findAddress(Long idAddressToUpdate) {
        var addressToUpdate = addressRepository.findFirstBy(createIdQueryFields(idAddressToUpdate));
        validateAddresToUpdate(addressToUpdate);
        return addressToUpdate;
    }

    private List<QueryFieldVO> createIdQueryFields(Long idAddressToUpdate) {
        QueryFieldVO field = new QueryFieldVO("id", idAddressToUpdate);
        return List.of(field);
    }

    private void validateAddresToUpdate(AddressBO addressToUpdate) {
        if (addressToUpdate == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }
        if (addressToUpdate.getDisabledAt() != null) {
            throw new CrudException(EnumCrudError.ITEM_ESTA_DESABILITADO, "identificador");
        }
    }

}
