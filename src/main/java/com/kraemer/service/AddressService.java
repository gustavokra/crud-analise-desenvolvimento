package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldInfoVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.usecases.address.CreateAddress;
import com.kraemer.domain.usecases.address.DisableAddress;
import com.kraemer.domain.usecases.address.ReturnAddressBy;
import com.kraemer.domain.usecases.address.ReturnAllAddress;
import com.kraemer.domain.usecases.address.UpdateAddressInfo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AddressService extends AbstractService {

    @Transactional
    public AddressDTO createAddress(AddressDTO dto, EnumDataBase dataBase) {
        AddressRepository repository = repositoryFactory.getAddressRepository(dataBase);

        var createAddress = new CreateAddress(repository);

        return createAddress.execute(dto);
    }

    public List<AddressDTO> returnAllAddress(EnumDataBase dataBase) {
        AddressRepository repository = repositoryFactory.getAddressRepository(dataBase);

        var findAllAddress = new ReturnAllAddress(repository);

        return findAllAddress.execute(true);
    }

    public AddressDTO returnAddress(Long id, EnumDataBase database) {
        AddressRepository addressRepository = repositoryFactory.getAddressRepository(database);

        var returnAddressBy = new ReturnAddressBy(addressRepository);

        QueryFieldInfoVO queryFieldInfo = new QueryFieldInfoVO("id", id);

        return returnAddressBy.execute(List.of(queryFieldInfo), true);
    }

    @Transactional
    public AddressDTO updateAddressInfo(AddressDTO addressDTO, Long idAddressToUpdate, EnumDataBase dataBase) {
        AddressRepository addressRepository = repositoryFactory.getAddressRepository(dataBase);

        var updateAddressInfo = new UpdateAddressInfo(addressRepository);

        return updateAddressInfo.execute(addressDTO, idAddressToUpdate);
    }

    @Transactional
    public AddressDTO disableAddress(Long id, EnumDataBase dataBase) {
        AddressRepository addressRepository = repositoryFactory.getAddressRepository(dataBase);

        var disableAddress = new DisableAddress(addressRepository);

        return disableAddress.execute(id);
    }

}
