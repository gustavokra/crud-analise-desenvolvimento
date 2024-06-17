package com.kraemer.domain.usecases.address;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.AddressRepository;

public class CreateAddress {

    private AddressRepository addressRepository;

    public CreateAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto) {
        AddressBO addressBO = AddressMapper.toBO(dto);
        addressBO = addressRepository.create(addressBO);

        return AddressMapper.toDTO(addressBO);
    }

}
