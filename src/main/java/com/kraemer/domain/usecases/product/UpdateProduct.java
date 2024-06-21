package com.kraemer.domain.usecases.product;

import java.util.List;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.ProductMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.exception.CrudException;

public class UpdateProduct {

    private ProductRepository repository;    

    public UpdateProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(ProductDTO dto, Long id) {

        var queryField = new QueryFieldVO("id", id);

        var productToUpdate = repository.findFirstBy(List.of(queryField));
        
        if(productToUpdate == null) {
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, "identificador");
        }

        productToUpdate.handleUpdate(ProductMapper.toBO(dto));

        return ProductMapper.toDTO(repository.merge(productToUpdate));
        
    }

}
