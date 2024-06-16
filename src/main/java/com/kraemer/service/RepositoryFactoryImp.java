package com.kraemer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.repositories.AddressRepository;
import com.kraemer.domain.repositories.UserRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositoryFactoryImp {
    @All
    private List<UserRepository> userRepositoryimplementations;

    @All
    private List<AddressRepository> addressRepositoryimplementations;

    private static final Map<EnumDataBase, UserRepository> userRepositoryImplByDataBases = new HashMap<>();
    private static final Map<EnumDataBase, AddressRepository> addressRepositoryImplByDataBases = new HashMap<>();

    @PostConstruct
    public void init() {
        for (UserRepository implementation : userRepositoryimplementations) {
            userRepositoryImplByDataBases.put(implementation.getDataBase(), implementation);
        }

        for(AddressRepository implementation : addressRepositoryimplementations) {
            addressRepositoryImplByDataBases.put(implementation.getDataBase(), implementation);
        }
    }

    public UserRepository getUserRepository(EnumDataBase dataBase) {
        UserRepository repository = userRepositoryImplByDataBases.get(dataBase);

        if (repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }

        return repository;
    }

    public AddressRepository getAddressRepository(EnumDataBase dataBase) {
        AddressRepository repository = addressRepositoryImplByDataBases.get(dataBase);

        if (repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }

        return repository;
    }
}
