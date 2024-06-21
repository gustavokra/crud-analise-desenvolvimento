package com.kraemer.domain.usecases.product;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.mappers.ProductMapper;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.ListUtil;

public class ReturnAllProducts {

    private ProductRepository repository;

    public ReturnAllProducts(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> execute() {
        return ListUtil.stream(repository.returnAll())
                    .map(ProductMapper::toDTO)
                    .collect(Collectors.toList());
    }

}
