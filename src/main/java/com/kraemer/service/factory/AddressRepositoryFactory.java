package com.kraemer.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressRepositoryFactory {

    @All
    private List<AddressRepository> repositoryImplementations;

    private static final Map<EnumDataBase, AddressRepository> serviceCache = new HashMap<>();
    
    @PostConstruct
    public void init() {
        for(AddressRepository implementation : repositoryImplementations) {
            serviceCache.put(implementation.getDataBase(), implementation);
        }
    }

    public AddressRepository getRepository(EnumDataBase database) {
        var repository = serviceCache.get(database);
        if(repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }
        return serviceCache.get(database);
    }

}
