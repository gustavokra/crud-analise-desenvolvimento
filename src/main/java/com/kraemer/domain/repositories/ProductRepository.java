package com.kraemer.domain.repositories;

import java.util.List;

import com.kraemer.domain.entities.ProductBO;
import com.kraemer.domain.entities.enums.EnumDataBase;
import com.kraemer.domain.entities.vo.QueryFieldVO;

public interface ProductRepository {
    
    ProductBO create(ProductBO productBO);
    
    ProductBO merge(ProductBO productBO);
    
    List<ProductBO> returnAll();
    
    ProductBO findFirstBy(List<QueryFieldVO> queryFields);
    
    List<ProductBO> listBy(List<QueryFieldVO> queryFields);

    EnumDataBase getDataBase();
    
}