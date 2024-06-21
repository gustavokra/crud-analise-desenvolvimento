package com.kraemer.domain.usecases.product;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.mappers.ProductMapper;
import com.kraemer.domain.repositories.ProductRepository;

public class CreateProduct {
    
    private ProductRepository repository;

    public CreateProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(ProductDTO dto) {
        var createdProduct = repository.create(ProductMapper.toBO(dto));
        return ProductMapper.toDTO(createdProduct);
    }

}