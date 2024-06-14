package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.CountryBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MysqlCountry;

public class MysqlCountryMapper {

    public static CountryBO toDomain(MysqlCountry entity) {
        return new CountryBO(entity.getId(),
                entity.getDescription(),
                entity.getAcronym(),
                new CreatedAtVO(entity.getCreatedAt()),
                entity.getUpdatedAt(),
                entity.getDisableAt());
    }

    public static MysqlCountry toEntity(CountryBO bo) {
        MysqlCountry entity = new MysqlCountry();
        entity.setId(bo.getId());
        entity.setDescription(bo.getDescription());
        entity.setAcronym(bo.getAcronym());
        entity.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt().getValue() : null);
        entity.setUpdatedAt(bo.getUpdatedAt());
        entity.setDisableAt(bo.getDisabledAt());
        return entity;
    }


}
