package com.kraemer.service;

import com.kraemer.infra.database.mysql.repositories.MySqlUserRepository;

import jakarta.inject.Inject;

public class AbstractService {

    @Inject
    MySqlUserRepository mySqlUserRepository;

    @Inject
    DbFactory dbFactory;

}
