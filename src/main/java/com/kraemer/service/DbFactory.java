package com.kraemer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.repositories.IAddressRepository;
import com.kraemer.domain.repositories.IUserRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DbFactory {
    @All
    private List<IUserRepository> userRepositoryimplementations;

    @All
    private List<IAddressRepository> adressRepositoryimplementations;

    private static final Map<EnumDBImpl, IUserRepository> userServiceCache = new HashMap<>();
    private static final Map<EnumDBImpl, IAddressRepository> addressServiceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (IUserRepository impl : userRepositoryimplementations) {
            userServiceCache.put(impl.getType(), impl);
        }

        for(IAddressRepository impl : adressRepositoryimplementations) {
            addressServiceCache.put(impl.getType(), impl);
        }
    }

    public IUserRepository getUserRepoImpl(EnumDBImpl impl) {
        IUserRepository repository = userServiceCache.get(impl);

        if (repository == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "dbImpl");
        }

        return repository;
    }

    public IAddressRepository getAdressRepoImpl(EnumDBImpl impl) {
        IAddressRepository repository = addressServiceCache.get(impl);

        if (repository == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "dbImpl");
        }

        return repository;
    }
}
