package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MysqlState;

public class MysqlStateMapper {

    public static StateBO toDomain(MysqlState mysqlAddress) {
        return new StateBO(mysqlAddress.getId(),
        mysqlAddress.getDescription(),
        mysqlAddress.getAcronym(),
        new CreatedAtVO(mysqlAddress.getCreatedAt()),
        mysqlAddress.getUpdatedAt(),
        mysqlAddress.getDisabledAt());
    }
    
    public static MysqlState toEntity(StateBO stateBO) {
        MysqlState mysqlState = new MysqlState();
        mysqlState.setId(stateBO.getId());
        mysqlState.setDescription(stateBO.getDescription());
        mysqlState.setAcronym(stateBO.getAcronym());
        return mysqlState;
    }

}
