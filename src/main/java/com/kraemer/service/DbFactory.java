package com.kraemer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.domain.entities.enums.EnumErrorCode;
import com.kraemer.domain.repositories.ICrudRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DbFactory {
    @All
    private List<ICrudRepository<UserBO>> userRepositoryimplementations;
    private List<ICrudRepository<AddressBO>> adressRepositoryimplementations;

    private static final Map<EnumDBImpl, ICrudRepository<UserBO>> userServiceCache = new HashMap<>();
    private static final Map<EnumDBImpl, ICrudRepository<AddressBO>> addressServiceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (ICrudRepository<UserBO> impl : userRepositoryimplementations) {
            userServiceCache.put(impl.getType(), impl);
        }

        for(ICrudRepository<AddressBO> impl : adressRepositoryimplementations) {
            addressServiceCache.put(impl.getType(), impl);
        }
    }

    public ICrudRepository<UserBO> getUserRepoImpl(EnumDBImpl impl) {
        ICrudRepository<UserBO> repository = userServiceCache.get(impl);

        if (repository == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "dbImpl");
        }

        return repository;
    }

    public ICrudRepository<AddressBO> getAdressRepoImpl(EnumDBImpl impl) {
        ICrudRepository<AddressBO> repository = addressServiceCache.get(impl);

        if (repository == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "dbImpl");
        }

        return repository;
    }
}
