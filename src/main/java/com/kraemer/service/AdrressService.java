package com.kraemer.service;

import com.kraemer.domain.entities.dto.AddressDTO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.infra.database.mysql.repositories.MysqlAddressRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class AdrressService extends AbstractService {

    @Inject
    private MysqlAddressRepository mysqlAddressRepository;
    
    public AddressDTO create(AddressDTO dto, EnumDBImpl dbImpl) {
        
        IAddressRepository repository = dbFactory.getAdressRepoImpl(dbImpl);
        

    }

}
