package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.ProductBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlProduct;

public class MySqlProductMapper {
    
    public static ProductBO toBO(MySqlProduct entity) {
        return new ProductBO(entity.getId(), 
        MySqlStockMapper.toBO(entity.getStock()), 
        entity.getDescription(), 
        new CreatedAtVO(entity.getCreatedAt()), 
        entity.getUpdatedAt(), 
        entity.getDisabledAt());
    }

    public static MySqlProduct toEntity(ProductBO bo) {
        MySqlProduct entity = new MySqlProduct();
        entity.setId(bo.getId());
        entity.setDescription(bo.getDescription());
        entity.setStock(MySqlStockMapper.toEntity(bo.getStockBO()));
        entity.setCreatedAt(bo.getCreatedAt().getValue());
        entity.setUpdatedAt(bo.getUpdatedAt());
        entity.setDisabledAt(bo.getDisabledAt());

        return entity;
    }
}
