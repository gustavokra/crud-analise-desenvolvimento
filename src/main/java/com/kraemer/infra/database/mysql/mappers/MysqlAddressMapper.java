package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.AddressBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlAddress;

public class MysqlAddressMapper {

    public static AddressBO mySqlAddressToAddressBO(MySqlAddress mySqlAddress) {
        return new AddressBO(mySqlAddress.getId(),
                MysqlCountryMapper.toDomain(mySqlAddress.getCountry()),
                MysqlStateMapper.toDomain(mySqlAddress.getState()),
                MysqlCityMapper.toDomain(mySqlAddress.getCity()),
                mySqlAddress.getNeighborhood(),
                mySqlAddress.getStreet(),
                mySqlAddress.getNumber(),
                new CreatedAtVO(mySqlAddress.getCreatedAt()),
                mySqlAddress.getUpdatedAt(),
                mySqlAddress.getDisabledAt());
    }

    public static MySqlAddress addressBOToMySqlAddress(AddressBO addressBO) {
        MySqlAddress mysqlAddress = new MySqlAddress();
        mysqlAddress.setId(addressBO.getId());
        mysqlAddress.setCountry(MysqlCountryMapper.toEntity(addressBO.getCountryBO()));
        mysqlAddress.setState(MysqlStateMapper.toEntity(addressBO.getStateBO()));
        mysqlAddress.setCity(MysqlCityMapper.toEntity(addressBO.getCityBO()));
        mysqlAddress.setNeighborhood(addressBO.getNeighborhood());
        mysqlAddress.setStreet(addressBO.getStreet());
        mysqlAddress.setNumber(addressBO.getNumber());
        return mysqlAddress;
    }

}
