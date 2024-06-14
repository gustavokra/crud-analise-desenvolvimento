package com.kraemer.domain.usecases.address;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.IAddressRepository;

public class CreateAddress {

    private IAddressRepository addressRepository;

    public CreateAddress(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto) {
        var addressBO = AddressMapper.toBO(dto);
        addressBO = addressRepository.create(addressBO);

        return AddressMapper.toDTO(addressBO);
    }

}
