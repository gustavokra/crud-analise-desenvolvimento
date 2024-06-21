package com.kraemer.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;

public class ProductRepositoryFactory {
    @All
    private List<ProductRepository> repositoryImplementations;

    private static final Map<EnumDataBase, ProductRepository> serviceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (ProductRepository implementation : repositoryImplementations) {
            serviceCache.put(implementation.getDataBase(), implementation);
        }
    }

    public ProductRepository getRepository(EnumDataBase database) {
        var repository = serviceCache.get(database);

        if (repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }

        return serviceCache.get(database);
    }

}
