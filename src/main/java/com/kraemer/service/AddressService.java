package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.usecases.address.CreateAddress;
import com.kraemer.domain.usecases.address.ReturnAllAddress;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class AddressService extends AbstractService {
    
    @Transactional
    public AddressDTO createAddress(AddressDTO dto, EnumDataBase dataBase) {
        AddressRepository repository = repositoryFactory.getAddressRepository(dataBase);
        CreateAddress createAddress = new CreateAddress(repository);

        return createAddress.execute(dto);
    }

    public List<AddressDTO> returnAllAddress(EnumDataBase dataBase) {
        AddressRepository repository = repositoryFactory.getAddressRepository(dataBase);
        ReturnAllAddress findAllAddress = new ReturnAllAddress(repository);

        return findAllAddress.execute(true);
    }

}
