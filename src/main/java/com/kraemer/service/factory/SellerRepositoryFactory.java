package com.kraemer.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.repositories.SellerRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SellerRepositoryFactory {
    
    @All
    private List<SellerRepository> repositoryImplementations;

    private static final Map<EnumDataBase, SellerRepository> serviceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (SellerRepository implementation : repositoryImplementations) {
            serviceCache.put(implementation.getDataBase(), implementation);
        }
    }

    public SellerRepository getRepository(EnumDataBase database) {
        var repository = serviceCache.get(database);

        if (repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }

        return serviceCache.get(database);
    }

}
