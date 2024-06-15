package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MysqlAddress;

public class MysqlAddressMapper {

    public static AddressBO toDomain(MysqlAddress entity) {
        return new AddressBO(entity.getId(),
                MysqlCountryMapper.toDomain(entity.getCountry()),
                MysqlStateMapper.toDomain(entity.getState()),
                MysqlCityMapper.toDomain(entity.getCity()),
                entity.getNeighborhood(),
                entity.getStreet(),
                entity.getNumber(),
                new CreatedAtVO(entity.getCreatedAt()),
                entity.getUpdatedAt(),
                entity.getDisabledAt());
    }

    public static MysqlAddress toEntity(AddressBO bo) {
        MysqlAddress mysqlAddress = new MysqlAddress();
        mysqlAddress.setId(bo.getId());
        mysqlAddress.setCountry(MysqlCountryMapper.toEntity(bo.getCountryBO()));
        mysqlAddress.setState(MysqlStateMapper.toEntity(bo.getStateBO()));
        mysqlAddress.setCity(MysqlCityMapper.toEntity(bo.getCityBO()));
        mysqlAddress.setNeighborhood(bo.getNeighborhood());
        mysqlAddress.setStreet(bo.getStreet());
        mysqlAddress.setNumber(bo.getNumber());
        return mysqlAddress;
    }

}
