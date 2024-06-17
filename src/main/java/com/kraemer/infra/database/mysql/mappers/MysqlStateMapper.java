package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.vo.CreationDateVO;
import com.kraemer.infra.database.mysql.model.MySqlState;

public class MysqlStateMapper {

    public static StateBO toDomain(MySqlState mysqlAddress) {
        return new StateBO(mysqlAddress.getId(),
        mysqlAddress.getDescription(),
        mysqlAddress.getAcronym(),
        new CreationDateVO(mysqlAddress.getCreatedAt()),
        mysqlAddress.getUpdatedAt(),
        mysqlAddress.getDisabledAt());
    }
    
    public static MySqlState toEntity(StateBO stateBO) {
        MySqlState mysqlState = new MySqlState();
        mysqlState.setId(stateBO.getId());
        mysqlState.setDescription(stateBO.getDescription());
        mysqlState.setAcronym(stateBO.getAcronym());
        return mysqlState;
    }

}
