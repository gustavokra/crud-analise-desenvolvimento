package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.CountryBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlCountry;

public class MysqlCountryMapper {

    public static CountryBO toDomain(MySqlCountry entity) {
        return new CountryBO(entity.getId(),
                entity.getDescription(),
                entity.getAcronym(),
                new CreatedAtVO(entity.getCreatedAt()),
                entity.getUpdatedAt(),
                entity.getDisabledAt());
    }

    public static MySqlCountry toEntity(CountryBO bo) {
        MySqlCountry entity = new MySqlCountry();
        entity.setId(bo.getId());
        entity.setDescription(bo.getDescription());
        entity.setAcronym(bo.getAcronym());
        entity.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt().getValue() : null);
        entity.setUpdatedAt(bo.getUpdatedAt());
        entity.setDisabledAt(bo.getDisabledAt());
        return entity;
    }


}
