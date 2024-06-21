package com.kraemer.service;

import java.util.List;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.usecases.address.CreateAddress;
import com.kraemer.domain.usecases.address.DisableAddress;
import com.kraemer.domain.usecases.address.FindAddressBy;
import com.kraemer.domain.usecases.address.ReturnAllAddress;
import com.kraemer.domain.usecases.address.UpdateAddress;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AddressService extends AbstractService {

    @Transactional
    public AddressDTO create(AddressDTO dto, EnumDataBase dataBase) {
        AddressRepository repository = addressRepositoryFactory.getRepository(dataBase);
        var createAddress = new CreateAddress(repository);
        return createAddress.execute(dto);
    }

    public List<AddressDTO> returnAll(EnumDataBase dataBase) {
        AddressRepository repository = addressRepositoryFactory.getRepository(dataBase);
        var findAllAddress = new ReturnAllAddress(repository);
        return findAllAddress.execute(true);
    }

    public AddressDTO findById(Long id, EnumDataBase database) {
        AddressRepository addressRepository = addressRepositoryFactory.getRepository(database);
        var findAddressBy = new FindAddressBy(addressRepository);
        QueryFieldVO queryFieldInfo = new QueryFieldVO("id", id);
        return findAddressBy.execute(List.of(queryFieldInfo), true);
    }

    @Transactional
    public AddressDTO update(AddressDTO addressDTO, Long idAddressToUpdate, EnumDataBase dataBase) {
        AddressRepository addressRepository = addressRepositoryFactory.getRepository(dataBase);
        var updateAddressInfo = new UpdateAddress(addressRepository);
        return updateAddressInfo.execute(addressDTO, idAddressToUpdate);
    }

    @Transactional
    public AddressDTO disable(Long id, EnumDataBase dataBase) {
        AddressRepository addressRepository = addressRepositoryFactory.getRepository(dataBase);
        var disableAddress = new DisableAddress(addressRepository);
        return disableAddress.execute(id);
    }

}
