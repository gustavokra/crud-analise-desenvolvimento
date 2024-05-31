package org.acme.service;

import org.acme.infra.database.mysql.repositories.MySqlUserRepository;

import jakarta.inject.Inject;

public class AbstractService {

    @Inject
    MySqlUserRepository mySqlUserRepository;

    @Inject
    DbFactory dbFactory;

}
