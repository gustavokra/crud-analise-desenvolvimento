package com.kraemer.service;

import com.kraemer.service.factory.AddressRepositoryFactory;
import com.kraemer.service.factory.ClientRepositoryFactory;
import com.kraemer.service.factory.ProductRepositoryFactory;
import com.kraemer.service.factory.StockRepositoryFactory;
import com.kraemer.service.factory.UserRepositoryFactoryImp;

import jakarta.inject.Inject;

public class AbstractService {

    @Inject
    UserRepositoryFactoryImp userRepositoryFactory;

    @Inject
    AddressRepositoryFactory addressRepositoryFactory;

    @Inject
    StockRepositoryFactory stockRepositoryFactory;

    @Inject
    ProductRepositoryFactory productRepositoryFactory;

    @Inject 
    ClientRepositoryFactory clientRepositoryFactory;

}
