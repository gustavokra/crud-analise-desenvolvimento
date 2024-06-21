package com.kraemer.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.repositories.StockRepository;
import com.kraemer.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockRepositoryFactory {

    @All
    private List<StockRepository> repositoryImplementations;

    private Map<EnumDataBase, StockRepository> serviceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (StockRepository implementation : repositoryImplementations) {
            serviceCache.put(implementation.getDataBase(), implementation);
        }
    }

    public StockRepository getRepository(EnumDataBase dataBase) {
        var repository = serviceCache.get(dataBase);

        if (repository == null) {
            throw new CrudException(EnumCrudError.CAMPO_OBRIGATORIO, "dataBase");
        }

        return repository;
    }

}
