package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.StockBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlStock;

public class MySqlStockMapper {
    
    public static StockBO toBO(MySqlStock entity) {
        return new StockBO(
            entity.getId(), 
            entity.getDescription(),
            new CreatedAtVO(entity.getCreatedAt()),
            entity.getUpdatedAt(), 
            entity.getDisableAt());
    }

    public static MySqlStock toEntity(StockBO bo) {
        MySqlStock entity = new MySqlStock();
        entity.setId(bo.getId());
        entity.setDescription(bo.getDescription());
        entity.setCreatedAt(bo.getCreatedAt().getValue());
        entity.setUpdatedAt(bo.getUpdatedAt());
        entity.setDisableAt(bo.getDisabledAt());
        return entity;
    }

}
