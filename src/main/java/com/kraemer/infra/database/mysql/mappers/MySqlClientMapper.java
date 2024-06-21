package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.ClientBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlClient;

public class MySqlClientMapper {

    public static MySqlClient toEntity(ClientBO bo) {
        MySqlClient entity = new MySqlClient();
        entity.setId(bo.getId());
        entity.setName(bo.getName());
        entity.setAddress(MysqlAddressMapper.toEntity(bo.getAddressBO()));
        entity.setCreatedAt(bo.getCreatedAt().getValue());
        entity.setUpdatedAt(bo.getUpdatedAt());
        entity.setDisabledAt(bo.getDisabledAt());
        return entity;
    }

    public static ClientBO toBO(MySqlClient entity) {
        return new ClientBO(entity.getId(),
                entity.getName(),
                MysqlAddressMapper.toBO(entity.getAddress()),
                new CreatedAtVO(entity.getCreatedAt()),
                entity.getUpdatedAt(),
                entity.getDisabledAt());
    }

}
