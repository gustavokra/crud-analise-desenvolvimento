package org.acme.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acme.domain.entities.enums.EnumDBImpl;
import org.acme.domain.entities.enums.EnumErrorCode;
import org.acme.domain.repositories.IUserRepository;
import org.acme.domain.utils.exception.CrudException;

import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DbFactory {
    @All
    private List<IUserRepository> implementations;

    private static final Map<EnumDBImpl, IUserRepository> serviceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (IUserRepository impl : implementations) {
            serviceCache.put(impl.getType(), impl);
        }
    }

    public IUserRepository getImpl(EnumDBImpl impl) {
        IUserRepository repository = serviceCache.get(impl);

        if (repository == null) {
            throw new CrudException(EnumErrorCode.CAMPO_OBRIGATORIO, "dbImpl");
        }

        return repository;
    }
}
