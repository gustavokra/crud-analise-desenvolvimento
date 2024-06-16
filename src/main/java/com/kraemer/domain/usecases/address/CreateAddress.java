package com.kraemer.domain.usecases.address;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.AddressRepository;

public class CreateAddress {

    private AddressRepository addressRepository;

    public CreateAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto) {
        var addressBO = AddressMapper.mapAddressDTOToBO(dto);
        addressBO = addressRepository.create(addressBO);

        return AddressMapper.mapAddressBOToDTO(addressBO);
    }

}
