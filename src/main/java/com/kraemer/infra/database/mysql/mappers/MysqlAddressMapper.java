package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.infra.database.mysql.model.MysqlAddress;

public class MysqlAddressMapper {

    public static AddressBO toDomain(MysqlAddress entity) {
        return new AddressBO(entity.getId(),
                MysqlCountryMapper.toDomain(entity.getCountry()),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

}
