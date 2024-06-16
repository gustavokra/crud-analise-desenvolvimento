package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.usecases.address.CreateAddress;
import com.kraemer.domain.usecases.address.FindAllAddress;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class AddressService extends AbstractService {
    
    @Transactional
    public AddressDTO create(AddressDTO dto, EnumDBImpl dataBase) {
        IAddressRepository repository = dbFactory.getAdressRepoImpl(dataBase);
        var createAddress = new CreateAddress(repository);

        return createAddress.execute(dto);
    }

    public List<AddressDTO> returnAllAddress(EnumDBImpl dataBase) {
        IAddressRepository repository = dbFactory.getAdressRepoImpl(dataBase);
        var findAllAddress = new FindAllAddress(repository);

        return findAllAddress.execute(true);
    }

}
