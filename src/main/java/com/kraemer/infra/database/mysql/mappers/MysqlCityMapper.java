package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.CityBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlCity;

public class MysqlCityMapper {
    
    public static CityBO toDomain(MySqlCity entity) {
        return new CityBO(entity.getId(), 
        entity.getDescription(), 
        new CreatedAtVO(entity.getCreatedAt()), 
        entity.getUpdatedAt(), 
        entity.getDisabledAt());
    }

    public static MySqlCity toEntity(CityBO bo) {
        MySqlCity mysqlCity = new MySqlCity();
        mysqlCity.setId(bo.getId());
        mysqlCity.setDescription(bo.getDescription());
        mysqlCity.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt().getValue() : null);
        mysqlCity.setUpdatedAt(bo.getUpdatedAt());
        return mysqlCity;
    }

}
