package com.kraemer.infra.database.mysql.mappers;

import com.kraemer.domain.entities.StateBO;
import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.infra.database.mysql.model.MySqlState;

public class MysqlStateMapper {

    public static StateBO toDomain(MySqlState mySqlState) {
        return new StateBO(mySqlState.getId(),
        mySqlState.getDescription(),
        mySqlState.getAcronym(),
        new CreatedAtVO(mySqlState.getCreatedAt()),
        mySqlState.getUpdatedAt(),
        mySqlState.getDisabledAt());
    }
    
    public static MySqlState toEntity(StateBO stateBO) {
        MySqlState mysqlState = new MySqlState();
        mysqlState.setId(stateBO.getId());
        mysqlState.setDescription(stateBO.getDescription());
        mysqlState.setAcronym(stateBO.getAcronym());
        return mysqlState;
    }

}
