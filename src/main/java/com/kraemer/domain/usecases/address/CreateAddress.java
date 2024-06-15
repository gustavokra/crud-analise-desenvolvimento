package com.kraemer.domain.usecases.address;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.mappers.AddressMapper;
import com.kraemer.domain.repositories.ICrudRepository;

public class CreateAddress {

    private ICrudRepository<AddressBO> addressRepository;

    public CreateAddress(ICrudRepository<AddressBO> addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO dto) {
        var addressBO = AddressMapper.toBO(dto);
        addressBO = addressRepository.create(addressBO);

        return AddressMapper.toDTO(addressBO);
    }

}
