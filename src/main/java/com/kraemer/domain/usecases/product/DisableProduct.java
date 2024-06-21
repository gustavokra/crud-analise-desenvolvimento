package com.kraemer.domain.usecases.product;

import java.util.List;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.ProductMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class DisableProduct {
    
    private ProductRepository repository;

    public DisableProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(Long id) {
        QueryFieldVO queryField = new QueryFieldVO("id", id);
        var productToDisable = repository.findFirstBy(List.of(queryField));

        if(productToDisable == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        productToDisable.handleDisable();

        return ProductMapper.toDTO(repository.merge(productToDisable));
    }

}
