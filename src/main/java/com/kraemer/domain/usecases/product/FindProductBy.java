package com.kraemer.domain.usecases.product;

import java.util.List;
import java.util.stream.Collectors;

import com.kraemer.domain.entities.dto.ProductDTO;
import com.kraemer.domain.entities.enums.EnumCrudError;
import com.kraemer.domain.entities.mappers.ProductMapper;
import com.kraemer.domain.entities.vo.QueryFieldVO;
import com.kraemer.domain.repositories.ProductRepository;
import com.kraemer.domain.utils.ListUtil;
import com.kraemer.domain.utils.exception.CrudException;

public class FindProductBy {

    private ProductRepository repository;

    public FindProductBy(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(List<QueryFieldVO> queryFields, boolean throwsException) {
        var productBO = repository.findFirstBy(queryFields);

        if(productBO == null && throwsException) {
            var fields = ListUtil.stream(queryFields)
                    .map(QueryFieldVO::getFieldName)
                    .collect(Collectors.joining(", "));
            throw new CrudException(EnumCrudError.ITEM_NAO_ENCONTRADO_FILTROS, fields);
        }

        return productBO != null ? ProductMapper.toDTO(productBO) : null;
    }

}
